/* 
 * Основные понятия и определения.
 * 
 *                                                Структура класса
 * Структура класса в Java может включать в себя блок инициализации полей, блок статической инициализации,
 * блок нестатической инициализации для объекта класса, методы и конструкторы класса (как частный случай методов).
 * 
 *                                                Сигнатура метода
 * Это имя метода и параметры. В сигнатуру метода не входит возвращаемое значение, бросаемые им исключения, а также модификаторы
 * (ключевые слова public, protected, private, abstract, static, final, synchronized, native, strictfp и разнообразные аннотации).
 * 
 *                                                Круглые скобки ()
 * В контексте конструктора или метода, являются частью конструкции конструктора или метода соответственно, т.е. скобки используются
 * в сочетании с именем конструктора или метода (устанавливаются после имени) как при их объявлении (конструкторов или методов),
 * так и при обращении к ним. Например, параметры метода инициализируются внутри круглых скобок:
 * 
 * public void method(int a) {}
 * 
 * где method – имя инициализируемого метода, public и void – модификаторы метода, {} – тело метода, (int a) – конструкция,
 * содержащая инициализацию переменной типа int в качестве аргумента (параметра) метода.
 * 
 *                                                Фигурные скобки {}
 * Синтаксисом языка принято, что область действия каждого оператора (начало и конец) должна быть обозначена фигурными скобками.
 * Верхний уровень, как правило, обозначается оператором class и его область действия может включать инициализацию полей,
 * блок статической и нестатической инициализации, конструкторы и методы. Границы (начало и конец) конструкторов, методов
 * и блоков инициализации так же обязаны быть обозначены фигурными скобками. Кроме того, фигурными скобками могут быть объединены
 * один или несколько операторов в отдельный исполняемый блок.
 * Исполняемый код в этой структуре может находится только в теле метода (конструктора, как частный случай метода)
 * или блоке статической (нестатической для объекта) инициализации и запущен на исполнение по имени этого метода
 * (в случае блока статической (нестатической) инициализации - в момент создания класса).
 * 
 *                                                   Точка/dot .
 * Разделитель, в математических расчетах используется для выделения элементов из ссылки на объект,
 * в контекте операторов import и package – для доступа к вложенному пакету/объекту/классу,
 * в контексте классов и методов – для доступа к переменным/методам и т.п.
 * 
 *                                                Точка с запятой ;
 * Синтаксис ; (точка с запятой) используется для обозначения конца оператора.
 * Компилятор воспринимает наличие точки с запятой в коде как конец инструкции/выражения. */




/* Оператор package сообщает транслятору, в каком пакете должны определяться содержащиеся в данном файле (CalcMain.java) классы.
 * Пакеты задают набор раздельных пространств имен, в которых хранятся имена классов.
 * Если оператор package не указан, классы попадают в безымянное пространство имен, используемое по умолчанию.
 * Если объявляется класс, принадлежащий определенному пакету, например – package pi.KR;, то и исходный код этого класса
 * должен храниться в каталоге /pi.KR */
package pi.KR;

/* Оператор import позволяет обращаться к классам, содержащемся в пакете, который указан между операторами import и ;
 * Он служит только для удобства программистов и не является обязательным с технической точки зрения для создания
 * завершенной Java-программы.
 * Т.е. все стандартные классы хранятся в каком-либо именованном пакете и, поскольку внутри пакетов классы должны быть полностью
 * определены именем или именами их пакетов, использование класса без обращения к пакету (без использования оператора import),
 * в котором находится класс, заранее, будет представлять собой длинную запись, в которой первым будет записано обращение к пакету,
 * а после – к классу, например:
 * 
 * javax.swing.JTextField firstTextField = new javax.swing.JTextField("Первое текстовое поле");
 * javax.swing.JTextField secondTextField = new javax.swing.JTextField("Второе текстовое поле");
 * javax.swing.JTextField thirdTextField = new javax.swing.JTextField("Третье текстовое поле");
 * 
 * В случае использования директивы импорта создание трех вышеперечисленных объектов класса JTextField будет иметь следующий вид:
 * 
 * import javax.swing.JTextField;
 * JTextField firstTextField = new JTextField("Первое текстовое поле");
 * JTextField secondTextField = new JTextField("Второе текстовое поле");
 * JTextField thirdTextField = new JTextField("Третье текстовое поле"); */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/* Класс CalcMain является главным классом, определенным в данном файле (CalcMain.java).
 * Он наследуется от класса JFrame, поэтому для использования компонентов класса JFrame далее,
 * необходимость в объявлении объекта класса JFrame не возникнет. */
class CalcMain extends JFrame {
	
	/* private static final long serialVersionUID = 1L; – Конструкция используется для указания версии сериализованных данных.
	 * 
	 * Сериализация — процесс преобразования объекта в поток байтов для сохранения или передачи в память, базу данных или файл.
	 * Эта операция предназначена для того, чтобы сохранить состояния объекта для последующего воссоздания при необходимости.
	 * Обратный процесс называется десериализацией.
	 * 
	 * Среда выполнения сериализации связывает с каждым сериализуемым классом номер версии, называемый serialVersionUID,
	 * который используется во время десериализации для проверки того, что отправитель и получатель сериализованного объекта
	 * загрузили классы для этого объекта, которые совместимы в отношении сериализации.
	 * Если получатель загрузил класс для объекта, который имеет serialVersionUID отличный от класса соответствующего класса
	 * отправителя, то десериализация приведет к InvalidClassException.
	 * Сериализуемый класс может объявить свой собственный serialVersionUID явном виде, объявив поле с именем serialVersionUID
	 * которое должно быть статическим, конечным и типа long.
	 * Если сериализуемый класс явно не объявляет serialVersionUID, тогда среда выполнения сериализации вычислит значение
	 * serialVersionUID по умолчанию для этого класса на основе различных аспектов класса, как описано в
	 * Спецификации сериализации объектов Java (TM).
	 * Однако настоятельно рекомендуется, чтобы все сериализуемые классы явно объявляли значения serialVersionUID,
	 * так как вычисление serialVersionUID по умолчанию очень чувствительно к деталям класса, которые могут различаться
	 * в зависимости от реализаций компилятора, и, следовательно, могут привести к неожиданным InvalidClassExceptions
	 * во время десериализации.
	 * Поэтому, чтобы гарантировать согласованное значение serialVersionUID в различных реализациях Java-компилятора,
	 * сериализуемый класс должен объявить явное значение serialVersionUID.
	 * Также настоятельно рекомендуется, чтобы явные объявления serialVersionUID использовали модификатор private,
	 * где это возможно, поскольку такие объявления применяются только к немедленно объявленным полям класса.
	 * serialVersionUID не используются в качестве унаследованных членов. */
	private static final long serialVersionUID = 1L;
	
    /* Константы для расположения объектов:
     * x - отступ по ширине от левого края для области кнопок
     * y - отступ по высоте от верхнего края для области кнопок
     * xo - ширина объекта для области кнопок
     * xo - высота объекта для области кнопок
     * xI - отступ по ширине от левого края для области изображения
     * yI - отступ по высоте от верхнего края для области изображения
     * xoI - ширина объекта для области изображения
     * xoI - высота объекта для области изображения
     * Прочие переменные:
     * S1c - площадь одного стекла (применяется, если в остеклении используется больше 1 стекла) (Прямоугольная ОК)
     * S2c - площадь остекления типа double (Круглая ОК, Овальная ОК)
     * wfRec - площадь оконной рамы (Прямоугольная ОК)
     * wfRound - площадь оконной рамы (Круглая ОК)
     * wfOval - площадь оконной рамы (Овальная ОК)
     * selectedType - применяется для определения выбранного типа ОК в условии в слушателе кнопок
     * (0 - Прямоугольная ОК, 1 - Круглая ОК, 2 - Овальная ОК) */
    final int x = 229; final int y = 15; final int xo = 99; final int yo = 29;
    final int xI = 87; final int yI = 205; final int xoI = 100; final int yoI = 29;
    int S1c; double S2c; int wfRec; double wfRound; double wfOval; int selectedType = 0;
    
    /* Инициализация всех объектов.
     * 
     * Верхняя область окна содержит следующие объекты:
     * Текстовые поля: labelType, labelHeight, labelWeight, labelRadius, labelMaterial,
     * labelSealing, labelAnswer1, labelAnswer2 labelAnswer3, labelAnswer4;
     * Поля ввода: fieldHeight, fieldWeight, fieldRadius;
     * Выпадающие списки: comboBox1, comboBox2, comboBox3
     * Кнопки: buttonType, buttonCalculate;
     * 
     * Нижняя область окна содержит следующие объекты:
     * Текстовые поля: imageLabelHeight, imageLabelHeightError, imageLabelWeight, imageLabelWeightError,
     * imageLabelRadius, imageLabelRadiusError, imageLabelGlass1, imageLabelGlassError1 imageLabelGlass2,
     * imageLabelGlassError2, imageLabelSealing, imageLabelSealingError, imageLabelWfRec, imageLabelWfErrorRec,
     * imageLabelWfRound, imageLabelWfErrorRound, imageLabelWfOval, imageLabelWfErrorOval;
     * 
     * Прочие параметры:
     * error - строка со словом "Error", применяется для тектовых полей со словом Error в конце имени объекта;
     * tooLongError - применяется для проверки на переполнение в условиях в методе calculation();
     * newFieldHeight - строка со значением высоты, полученным после проверки и вычисления;
     * newFieldWeight - строка со значением ширины, полученным после проверки и вычисления;
     * newFieldRadius - строка со значением радиуса, полученным после проверки и вычисления;
     * newFieldGlass1 - строка со значением площади первого стекла, полученным после проверки и вычисления;
     * newFieldGlass2 - строка со значением площади второго стекла, полученным после проверки и вычисления;
     * newFieldSealing - строка со значением площади уплотнения, полученным после проверки и вычисления;
     * newFieldWfRec - строка со значением площади оконной рамы, полученным после проверки и вычисления (Прямоугольная ОК);
     * newFieldWfRound - строка со значением площади оконной рамы, полученным после проверки и вычисления (Круглая ОК);
     * newFieldWfOval - строка со значением площади оконной рамы, полученным после проверки и вычисления (Овальная ОК); */
    JLabel labelType = new JLabel("Выберите оконную конструкцию");
    JLabel labelHeight = new JLabel("Высота (см)");
    JLabel labelWeight = new JLabel("Ширина (см)");
    JLabel labelRadius = new JLabel("Радиус (см)");
    JLabel labelMaterial = new JLabel("Материал");
    JLabel labelSealing = new JLabel("Уплотнение");
    JLabel labelAnswer1 = new JLabel("");
    JLabel labelAnswer2 = new JLabel("");
    JLabel labelAnswer3 = new JLabel("");
    JLabel labelAnswer4 = new JLabel("");
    String error = "Error"; boolean tooLongError;
    JLabel imageLabelHeight = new JLabel(); JLabel imageLabelHeightError = new JLabel(error); String newFieldHeight;
    JLabel imageLabelWeight = new JLabel(); JLabel imageLabelWeightError = new JLabel(error); String newFieldWeight;
    JLabel imageLabelRadius = new JLabel(); JLabel imageLabelRadiusError = new JLabel(error); String newFieldRadius;
    JLabel imageLabelGlass1 = new JLabel(); JLabel imageLabelGlassError1 = new JLabel(error); String newFieldGlass1;
    JLabel imageLabelGlass2 = new JLabel(); JLabel imageLabelGlassError2 = new JLabel(error); String newFieldGlass2;
    JLabel imageLabelSealing = new JLabel(); JLabel imageLabelSealingError = new JLabel(error); String newFieldSealing;
    JLabel imageLabelWfRec = new JLabel(); JLabel imageLabelWfErrorRec = new JLabel(error); String newFieldWfRec;
    JLabel imageLabelWfRound = new JLabel(); JLabel imageLabelWfErrorRound = new JLabel(error); String newFieldWfRound;
    JLabel imageLabelWfOval = new JLabel(); JLabel imageLabelWfErrorOval = new JLabel(error); String newFieldWfOval;
    JTextField fieldHeight = new JTextField(10);
    JTextField fieldWeight = new JTextField(10);
    JTextField fieldRadius = new JTextField(10);
    JButton buttonCalculate = new JButton("Рассчитать");
    JButton buttonType = new JButton("Принять");
    String[] comboTypes = {"Прямоугольная", "Круглая", "Овальная", "Арочная", "Треугольная"};
    String[] comboMaterial = {"Дерево", "Алюминий", "ПВХ"};
    String[] comboSealing = {"Резиновое"};
    JComboBox<String> comboBox1 = new JComboBox<String>(comboTypes);
    JComboBox<String> comboBox2 = new JComboBox<String>(comboMaterial);
    JComboBox<String> comboBox3 = new JComboBox<String>(comboSealing);
    DecimalFormat format = new DecimalFormat("##.00");
	
	/* Конструктор. Метод super() устанавливает заголовок будущего окна. */
	public CalcMain() {
		super("Расчет оконной конструкции");
		createGUI();
    }
	
	/* Метод создает окно и располагает на нем графические объекты */
	public void createGUI() {
		/* Метод setDefaultCloseOperation() устанавливает условие, при котором окно будет закрыто.
		 * Параметр EXIT_ON_CLOSE указывает на то, что окно будет закрыто при нажатии кнопки 'Закрыть' (Close Box) */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/* Метод setSize() устанавливает размер окна, принимая параметры высоты и ширины в пикселях. */
        setSize(663,700);
        /* Задание начальной позиции окна – в центре экрана */
        setLocationRelativeTo(null);
        /* Установка видимости окна */
        setVisible(true);
        /* Запрещение изменения размеров окна */
        setResizable(false);
        /* Установка менеджера компоновки */
        setLayout(new BorderLayout());
        /* Добавление изображения */
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\pi\\KR\\RectWin.png")));
        
        /* Установка объектов и действий над ними:
         * Метод setBounds() устанавливает координаты объекта, add() - добавляет объект в окно,
         * setActionCommand() - устанавливает команду для идентификации кнопки */
        labelType.setBounds(x-199, y, xo+99, yo+1);
        comboBox1.setBounds(x-199, y+33, xo+99, yo);
        buttonType.setBounds(x-199, y+63, xo+99, yo+1);
        buttonType.setActionCommand("Принять");
        labelHeight.setBounds(x+13, y, xo+1, yo+1);
        labelWeight.setBounds(x+113, y, xo+1, yo+1);
        fieldHeight.setBounds(x, y+33, xo+1, yo+1);
        fieldWeight.setBounds(x+100, y+33, xo+1, yo+1);
        labelRadius.setBounds(x+67, y, xo+1, yo+1);
        fieldRadius.setBounds(x, y+33, xo+101, yo+1);
        labelMaterial.setBounds(x+220, y, xo+1, yo+1);
        labelSealing.setBounds(x+313, y, xo+1, yo+1);
        comboBox2.setBounds(x+200, y+33, xo, yo);
        comboBox3.setBounds(x+300, y+33, xo, yo);
        buttonCalculate.setBounds(x, y+63, xo+300, yo+1);
        buttonCalculate.setActionCommand("Рассчитать");
        labelAnswer1.setBounds(x-199, y+93, xo+301, yo+1);
        labelAnswer2.setBounds(x-160, y+113, xo+301, yo+1);
        labelAnswer3.setBounds(x-160, y+133, xo+301, yo+1);
        labelAnswer4.setBounds(x-160, y+153, xo+301, yo+1);
        
        add(labelType);
        add(labelHeight);
        add(labelWeight);
        add(labelMaterial);
        add(labelSealing);
        add(labelAnswer1);
        add(labelAnswer2);
        add(labelAnswer3);
        add(labelAnswer4);
        add(fieldHeight);
        add(fieldWeight);
        add(comboBox1);
        add(comboBox2);
        add(comboBox3);
        add(buttonType);
        add(buttonCalculate);
        
        /* Объявление объекта класса ActionListener и установка слушателя на кнопку через этот объект */
        ActionListener actionListener = new Actions();
        buttonCalculate.addActionListener(actionListener);
        buttonType.addActionListener(actionListener);
	}
	
    /* Метод расчета оконной конструкции */
	public int calculation(int h, int w) {
		S1c = -1; wfRec = -1; int forTest = 0;
		labelAnswer2.setText(""); labelAnswer3.setText(""); labelAnswer4.setText("");
		if (tooLongError == true) labelAnswer1.setText("(Значение одного или всех полей слишком длинное)");
		else if ((h == 0) || (w == 0)) labelAnswer1.setText("(Одно или все поля заполнены некорректно)");
		else {
			/* S - Площадь ОК без уплотнения, So - Общая площадь ОК, Sr - Площадь оконной рамы
			 * Su - Площадь уплотнения, Soc - Площадь остекления S1c - Площадь 1 стекла в многостекольной ОК
			 * h - высота, w - ширина, r - ширина оконной рамы, u - ширина внешнего уплотнения ОК */
			int S; int So; int Sr; int Su; int Soc; int u = 1; int r = comboBox2Check();
			S = h*w;
			So = (h+u)*(w+u);
			Sr = h*3*r+(w-3*r)*2;
			if (Sr > 0) wfRec = Sr;
			Su = So-S;
			Soc = So-Su-Sr;
			if (Soc > 0) S1c = Soc/2;
			forTest = So;
			if (So < 0) labelAnswer1.setText("Ответ: "+error+" (Общая площадь оконной конструкции)");
			else labelAnswer1.setText("Ответ: "+So+" см (Общая площадь оконной конструкции)");
			if (Sr < 0) labelAnswer2.setText(error+" (Площадь оконной рамы)");
			else labelAnswer2.setText(Sr+" см (Площадь оконной рамы)");
			if (Su < 0) labelAnswer3.setText(error+" (Площадь уплотнения)");
			else labelAnswer3.setText(Su+" см (Площадь уплотнения)");
			if (Soc < 0) labelAnswer4.setText(error+" (Площадь остекления)");
			else labelAnswer4.setText(Soc+" см (Площадь остекления)");
		}
		return forTest;
	}
	
	public void calculation(int rad) {
		S2c = -1; wfRound = -1;
		labelAnswer2.setText(""); labelAnswer3.setText(""); labelAnswer4.setText("");
		if (tooLongError == true) labelAnswer1.setText("(Значение в поле 'Радиус' слишком длинное)");
		else if ((rad == 0)) labelAnswer1.setText("(Поле 'Радиус' заполнено некорректно)");
		else {
			double newrad = rad; double S; double So; double Sr; double Su; double Soc; double u = 1; int r = comboBox2Check();
			S = Math.PI*Math.pow(newrad, 2);
			So = Math.PI*Math.pow(newrad+u, 2);
			Sr = S-Math.PI*Math.pow((newrad-r), 2);
			if (Sr > 0) wfRound = Sr;
			Su = So-S;
			Soc = So-Su-Sr;
			if (Soc > 0) S2c = Soc;
			if (So < 0) labelAnswer1.setText("Ответ: "+error+" (Общая площадь оконной конструкции)");
			else labelAnswer1.setText("Ответ: "+format.format(So)+" см (Общая площадь оконной конструкции)");
			if (Sr < 0) labelAnswer2.setText(error+" (Площадь оконной рамы)");
			else labelAnswer2.setText(format.format(Sr)+" см (Площадь оконной рамы)");
			if (Su < 0) labelAnswer3.setText(error+" (Площадь уплотнения)");
			else labelAnswer3.setText(format.format(Su)+" см (Площадь уплотнения)");
			if (Soc < 0) labelAnswer4.setText(error+" (Площадь остекления)");
			else labelAnswer4.setText(format.format(Soc)+" см (Площадь остекления)");
		}
	}
	
	public void calculation(int h, int w, int oval) {
		S2c = -1; wfOval = -1;
		labelAnswer2.setText(""); labelAnswer3.setText(""); labelAnswer4.setText("");
		if (tooLongError == true) labelAnswer1.setText("(Значение одного или всех полей слишком длинное)");
		else if ((h == 0) || (w == 0)) labelAnswer1.setText("(Одно или все поля заполнены некорректно)");
		else {
			double S; double So; double Sr; double Su; double Soc; double u = 1; int r = comboBox2Check();
			S = Math.PI*h*w;
			So = Math.PI*(h+u)*(w+u);
			Soc = Math.PI*(h-r)*(w-r);
			if (Soc > 0) S2c = Soc;
			Su = So-S;
			Sr = S-Soc;
			if (Sr > 0) wfOval = Sr;
			if (So < 0) labelAnswer1.setText("Ответ: "+error+" (Общая площадь оконной конструкции)");
			else labelAnswer1.setText("Ответ: "+format.format(So)+" см (Общая площадь оконной конструкции)");
			if (Sr < 0) labelAnswer2.setText(error+" (Площадь оконной рамы)");
			else labelAnswer2.setText(format.format(Sr)+" см (Площадь оконной рамы)");
			if (Su < 0) labelAnswer3.setText(error+" (Площадь уплотнения)");
			else labelAnswer3.setText(format.format(Su)+" см (Площадь уплотнения)");
			if (Soc < 0) labelAnswer4.setText(error+" (Площадь остекления)");
			else labelAnswer4.setText(format.format(Soc)+" см (Площадь остекления)");
		}
	}
	
	/* Метод проверки поля на ввод числа и переполнение. */
	public int fieldCheck(String word) {
		int zero = 0;
		/* Условие проверяет длину принятого полем слова, если она равна нулю, метод возвращает ноль. */
		if (word.length() == 0) return zero;
		else {
			/* Разбиение принятого полем слова на отдельные символы для посимвольной проверки. */
			char[] aword = word.toCharArray();
			String notZero = "0";
			/* В цикле проверяется условие соответствия символа цифре, при совпадении добавляет символ в новую строку. */
			for (int i = 0; i < aword.length; i++) {
				if ((aword[i] == '0') || (aword[i] == '1') || (aword[i] == '2') || (aword[i] == '3') || (aword[i] == '4')
				   || (aword[i] == '5') || (aword[i] == '6') || (aword[i] == '7') || (aword[i] == '8') || (aword[i] == '9'))
					notZero += aword[i];
			}
			/* Данная конструкция исключает сбой в работе программы из-за ошибки переполнения переменной zero при попытке
			 * присвоить ей значение из notZero. В случае возникновения ошибки переменной zero присваивается 5-значное число. */
			try {
				zero = Integer.valueOf(notZero);
			} catch(NumberFormatException e) {
				zero = 99999;
			}
			if (zero > 9999) tooLongError = true;
		}
		return zero;
	}
	
	/* Метод проверки значения из выпадающего списка 'Материал' (comboBox1). В случае, если был выбран 1-й элемент списка,
	 * для формул в методе calculate возвращается значение, соответствующее ширине деревянной рамы оконной конструкции (10 см),
	 * если 2-й элемент – значение алюминиевой рамы (5 см), 3-й элемент – значение пластиковой рамы (6 см). */
	public int comboBox2Check() {
		int windowFrameWidth = 0;
		/* Метод getSelectedIndex() возвращает значение индекса, соответствующего выбранному элементу выпадающего списка. */
		switch (comboBox2.getSelectedIndex()) {
		case 0: windowFrameWidth = 10; break;
		case 1:	windowFrameWidth = 5; break;
		case 2:	windowFrameWidth = 6; break;
		}
		return windowFrameWidth;
	}
	
	/* Метод производит замену изображения и перестановку объектов в зависимости от входного параметра:
	 * 0 – используется при нажатии кнопки 'Рассчитать' (buttonCalculate), если выбран прямоугольный тип ОК,
	 * 1 – используется при нажатии кнопки 'Принять' (buttonType), если выбран прямоугольный тип ОК,
	 * 2 – используется при нажатии кнопки 'Рассчитать' (buttonCalculate), если выбран круглый тип ОК,
	 * 3 – используется при нажатии кнопки 'Принять' (buttonType), если выбран круглый тип ОК,
	 * 4 – используется при нажатии кнопки 'Рассчитать' (buttonCalculate), если выбран овальный тип ОК,
	 * 0 – используется при нажатии кнопки 'Принять' (buttonType), если выбран ввальный тип ОК. */
	public void changeImage(int choose) {
		switch (choose) {
		case 0:
			selectedType = 0;
			labelAnswer1.setText(""); labelAnswer2.setText(""); labelAnswer3.setText(""); labelAnswer4.setText("");
			setContentPane(new JLabel(new ImageIcon("src\\main\\java\\pi\\KR\\RectWin.png")));
	        add(labelType);
	        add(comboBox1);
	        add(buttonType);
			add(labelHeight);
			add(labelWeight);
			add(fieldHeight);
			add(fieldWeight);
			add(labelMaterial);
			add(labelSealing);
			add(comboBox2);
			add(comboBox3);
	        add(buttonCalculate);
	        add(labelAnswer1);
	        add(labelAnswer2);
	        add(labelAnswer3);
	        add(labelAnswer4);
	        break;
		case 1:
			setContentPane(new JLabel(new ImageIcon("src\\main\\java\\pi\\KR\\RectWinProc.png")));
	        add(labelType);
	        add(comboBox1);
	        add(buttonType);
			add(labelHeight);
			add(labelWeight);
			add(fieldHeight);
			add(fieldWeight);
			add(labelMaterial);
			add(labelSealing);
			add(comboBox2);
			add(comboBox3);
	        add(buttonCalculate);
	        add(labelAnswer1);
	        add(labelAnswer2);
	        add(labelAnswer3);
	        add(labelAnswer4);
	        newFieldHeight = String.valueOf(fieldCheck(fieldHeight.getText()));
	        fieldHeight.setText(newFieldHeight);
	        switch (newFieldHeight.length()) {
	        case 1:
	        	imageLabelHeight.setText(newFieldHeight);
	        	imageLabelHeight.setBounds(xI+13, yI+223, xoI, yoI);
	        	add(imageLabelHeight);
	        	break;
	        case 2:
	        	imageLabelHeight.setText(newFieldHeight);
	        	imageLabelHeight.setBounds(xI+9, yI+223, xoI, yoI);
	        	add(imageLabelHeight);
	        	break;
	        case 3:
	        	imageLabelHeight.setText(newFieldHeight);
	        	imageLabelHeight.setBounds(xI+5, yI+223, xoI, yoI);
	        	add(imageLabelHeight);
	        	break;
	        case 4:
	        	imageLabelHeight.setText(newFieldHeight);
	        	imageLabelHeight.setBounds(xI+1, yI+223, xoI, yoI);
	        	add(imageLabelHeight);
	        	break;
	        default:
	        	imageLabelHeightError.setBounds(xI, yI+223, xoI, yoI);
	        	add(imageLabelHeightError);
	        }
	        newFieldWeight = String.valueOf(fieldCheck(fieldWeight.getText()));
	        fieldWeight.setText(newFieldWeight);
	        switch (newFieldWeight.length()) {
	        case 1:
	        	imageLabelWeight.setText(newFieldWeight);
	        	imageLabelWeight.setBounds(xI+245, yI, xoI, yoI);
	        	add(imageLabelWeight);
	        	break;
	        case 2:
	        	imageLabelWeight.setText(newFieldWeight);
	        	imageLabelWeight.setBounds(xI+241, yI, xoI, yoI);
	        	add(imageLabelWeight);
	        	break;
	        case 3:
	        	imageLabelWeight.setText(newFieldWeight);
	        	imageLabelWeight.setBounds(xI+237, yI, xoI, yoI);
	        	add(imageLabelWeight);
	        	break;
	        case 4:
	        	imageLabelWeight.setText(newFieldWeight);
	        	imageLabelWeight.setBounds(xI+233, yI, xoI, yoI);
	        	add(imageLabelWeight);
	        	break;
	        default:
	        	imageLabelWeightError.setBounds(xI+233, yI, xoI, yoI);
	        	add(imageLabelWeightError);
	        }
	        if (S1c < 0) {
	        	imageLabelGlassError1.setBounds(xI+140, yI+223, xoI, yoI);
	        	add(imageLabelGlassError1);
	        	imageLabelGlassError2.setBounds(xI+332, yI+223, xoI, yoI);
	        	add(imageLabelGlassError2);
	        } else {
		        newFieldGlass1 = String.valueOf(S1c);
		        switch (newFieldGlass1.length()) {
		        case 1:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+150, yI+223, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 2:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+146, yI+223, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 3:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+144, yI+223, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 4:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+140, yI+223, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 5:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+136, yI+223, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 6:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+132, yI+223, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 7:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+128, yI+223, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 8:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+124, yI+223, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        default:
		        	imageLabelGlassError1.setBounds(xI+140, yI+223, xoI, yoI);
		        	add(imageLabelGlassError1);
		        }
		        newFieldGlass2 = String.valueOf(S1c);
		        switch (newFieldGlass2.length()) {
		        case 1:
		        	imageLabelGlass2.setText(newFieldGlass2);
		        	imageLabelGlass2.setBounds(xI+344, yI+223, xoI, yoI);
		        	add(imageLabelGlass2);
		        	break;
		        case 2:
		        	imageLabelGlass2.setText(newFieldGlass2);
		        	imageLabelGlass2.setBounds(xI+340, yI+223, xoI, yoI);
		        	add(imageLabelGlass2);
		        	break;
		        case 3:
		        	imageLabelGlass2.setText(newFieldGlass2);
		        	imageLabelGlass2.setBounds(xI+336, yI+223, xoI, yoI);
		        	add(imageLabelGlass2);
		        	break;
		        case 4:
		        	imageLabelGlass2.setText(newFieldGlass2);
		        	imageLabelGlass2.setBounds(xI+332, yI+223, xoI, yoI);
		        	add(imageLabelGlass2);
		        	break;
		        case 5:
		        	imageLabelGlass2.setText(newFieldGlass2);
		        	imageLabelGlass2.setBounds(xI+328, yI+223, xoI, yoI);
		        	add(imageLabelGlass2);
		        	break;
		        case 6:
		        	imageLabelGlass2.setText(newFieldGlass2);
		        	imageLabelGlass2.setBounds(xI+324, yI+223, xoI, yoI);
		        	add(imageLabelGlass2);
		        	break;
		        case 7:
		        	imageLabelGlass2.setText(newFieldGlass2);
		        	imageLabelGlass2.setBounds(xI+320, yI+223, xoI, yoI);
		        	add(imageLabelGlass2);
		        	break;
		        case 8:
		        	imageLabelGlass2.setText(newFieldGlass2);
		        	imageLabelGlass2.setBounds(xI+316, yI+223, xoI, yoI);
		        	add(imageLabelGlass2);
		        	break;
		        default:
		        	imageLabelGlassError2.setBounds(xI+332, yI+223, xoI, yoI);
		        	add(imageLabelGlassError2);
		        }
	        }
	        newFieldWfRec = String.valueOf(wfRec);
	        if (wfRec < 0) {
	        	imageLabelWfErrorRec.setBounds(xI+58, yI+223, xoI, yoI);
		    	add(imageLabelWfErrorRec);
	        } else {
	        	imageLabelWfRec.setText(newFieldWfRec);
		    	imageLabelWfRec.setBounds(xI+58, yI+223, xoI, yoI);
		    	add(imageLabelWfRec);
	        }
	        newFieldSealing = String.valueOf(1);
	        imageLabelSealingError.setText(newFieldSealing);
	        imageLabelSealingError.setBounds(xI+31, yI, xoI, yoI);
		    add(imageLabelSealingError);
	        break;
		case 2:
			selectedType = 1;
			labelAnswer1.setText(""); labelAnswer2.setText(""); labelAnswer3.setText(""); labelAnswer4.setText("");
			setContentPane(new JLabel(new ImageIcon("src\\main\\java\\pi\\KR\\RoundWin.png")));
			add(labelType);
			add(comboBox1);
			add(buttonType);
			add(labelRadius);
			add(fieldRadius);
			add(labelMaterial);
			add(labelSealing);
			add(comboBox2);
			add(comboBox3);
			add(buttonCalculate);
			add(labelAnswer1);
			add(labelAnswer2);
			add(labelAnswer3);
			add(labelAnswer4);
			break;
		case 3:
			setContentPane(new JLabel(new ImageIcon("src\\main\\java\\pi\\KR\\RoundWinProc.png")));
			add(labelType);
			add(comboBox1);
			add(buttonType);
			add(labelRadius);
			add(fieldRadius);
			add(labelMaterial);
			add(labelSealing);
			add(comboBox2);
			add(comboBox3);
			add(buttonCalculate);
			add(labelAnswer1);
			add(labelAnswer2);
			add(labelAnswer3);
			add(labelAnswer4);
			newFieldRadius = String.valueOf(fieldCheck(fieldRadius.getText()));
	        fieldRadius.setText(newFieldRadius);
	        if (newFieldRadius.length() > 4) {
	        	imageLabelRadiusError.setBounds(xI+250, yI+109, xoI, yoI);
	        	add(imageLabelRadiusError);
	        } else {
	        	imageLabelRadius.setText(newFieldRadius);
	        	imageLabelRadius.setBounds(xI+250, yI+109, xoI, yoI);
	        	add(imageLabelRadius);
	        }
	        if (wfRound < 0) {
	        	imageLabelWfErrorRound.setBounds(xI+230, yI+23, xoI, yoI);
	        	add(imageLabelWfErrorRound);
	        } else {
		        newFieldWfRound = String.valueOf(format.format(wfRound));
		        switch (newFieldWfRound.length()) {
		        case 5:
		        	imageLabelWfRound.setText(newFieldWfRound);
			    	imageLabelWfRound.setBounds(xI+230, yI+23, xoI, yoI);
			    	add(imageLabelWfRound);
		        	break;
		        case 6:
		        	imageLabelWfRound.setText(newFieldWfRound);
			    	imageLabelWfRound.setBounds(xI+226, yI+23, xoI, yoI);
			    	add(imageLabelWfRound);
		        	break;
		        case 7:
		        	imageLabelWfRound.setText(newFieldWfRound);
			    	imageLabelWfRound.setBounds(xI+222, yI+23, xoI, yoI);
			    	add(imageLabelWfRound);
		        	break;
		        case 8:
		        	imageLabelWfRound.setText(newFieldWfRound);
			    	imageLabelWfRound.setBounds(xI+218, yI+23, xoI, yoI);
			    	add(imageLabelWfRound);
		        	break;
		        case 9:
		        	imageLabelWfRound.setText(newFieldWfRound);
			    	imageLabelWfRound.setBounds(xI+215, yI+23, xoI, yoI);
			    	add(imageLabelWfRound);
		        	break;
		        default:
		        	imageLabelWfErrorRound.setBounds(xI+230, yI+23, xoI, yoI);
		        	add(imageLabelWfErrorRound);
		        }
	        }
	        newFieldGlass1 = String.valueOf(format.format(S2c));
	        if (S2c < 0) {
	        	imageLabelGlassError1.setBounds(xI+251, yI+214, xoI, yoI);
	        	add(imageLabelGlassError1);
	        } else {
		        imageLabelGlass1.setText(newFieldGlass1);
		        imageLabelGlass1.setBounds(xI+250, yI+214, xoI, yoI);
		        add(imageLabelGlass1);
		        }
	        newFieldSealing = String.valueOf(1);
	        imageLabelSealingError.setText(newFieldSealing);
	        imageLabelSealingError.setBounds(xI+70, yI+48, xoI, yoI);
		    add(imageLabelSealingError);
			break;
		case 4:
			selectedType = 2;
			labelAnswer1.setText(""); labelAnswer2.setText(""); labelAnswer3.setText(""); labelAnswer4.setText("");
			setContentPane(new JLabel(new ImageIcon("src\\main\\java\\pi\\KR\\OvalWin.png")));
	        add(labelType);
	        add(comboBox1);
	        add(buttonType);
			add(labelHeight);
			add(labelWeight);
			add(fieldHeight);
			add(fieldWeight);
			add(labelMaterial);
			add(labelSealing);
			add(comboBox2);
			add(comboBox3);
	        add(buttonCalculate);
	        add(labelAnswer1);
	        add(labelAnswer2);
	        add(labelAnswer3);
	        add(labelAnswer4);
	        break;
		case 5:
			setContentPane(new JLabel(new ImageIcon("src\\main\\java\\pi\\KR\\OvalWinProc.png")));
	        add(labelType);
	        add(comboBox1);
	        add(buttonType);
			add(labelHeight);
			add(labelWeight);
			add(fieldHeight);
			add(fieldWeight);
			add(labelMaterial);
			add(labelSealing);
			add(comboBox2);
			add(comboBox3);
	        add(buttonCalculate);
	        add(labelAnswer1);
	        add(labelAnswer2);
	        add(labelAnswer3);
	        add(labelAnswer4);
	        newFieldHeight = String.valueOf(fieldCheck(fieldHeight.getText()));
	        fieldHeight.setText(newFieldHeight);
	        switch (newFieldHeight.length()) {
	        case 1:
	        	imageLabelHeight.setText(newFieldHeight);
	        	imageLabelHeight.setBounds(xI+67, yI+212, xoI, yoI);
	        	add(imageLabelHeight);
	        	break;
	        case 2:
	        	imageLabelHeight.setText(newFieldHeight);
	        	imageLabelHeight.setBounds(xI+62, yI+212, xoI, yoI);
	        	add(imageLabelHeight);
	        	break;
	        case 3:
	        	imageLabelHeight.setText(newFieldHeight);
	        	imageLabelHeight.setBounds(xI+56, yI+212, xoI, yoI);
	        	add(imageLabelHeight);
	        	break;
	        case 4:
	        	imageLabelHeight.setText(newFieldHeight);
	        	imageLabelHeight.setBounds(xI+49, yI+212, xoI, yoI);
	        	add(imageLabelHeight);
	        	break;
	        default:
	        	imageLabelHeightError.setBounds(xI+48, yI+212, xoI, yoI);
	        	add(imageLabelHeightError);
	        }
	        newFieldWeight = String.valueOf(fieldCheck(fieldWeight.getText()));
	        fieldWeight.setText(newFieldWeight);
	        switch (newFieldWeight.length()) {
	        case 1:
	        	imageLabelWeight.setText(newFieldWeight);
	        	imageLabelWeight.setBounds(xI+237, yI-4, xoI, yoI);
	        	add(imageLabelWeight);
	        	break;
	        case 2:
	        	imageLabelWeight.setText(newFieldWeight);
	        	imageLabelWeight.setBounds(xI+233, yI-4, xoI, yoI);
	        	add(imageLabelWeight);
	        	break;
	        case 3:
	        	imageLabelWeight.setText(newFieldWeight);
	        	imageLabelWeight.setBounds(xI+229, yI-4, xoI, yoI);
	        	add(imageLabelWeight);
	        	break;
	        case 4:
	        	imageLabelWeight.setText(newFieldWeight);
	        	imageLabelWeight.setBounds(xI+225, yI-4, xoI, yoI);
	        	add(imageLabelWeight);
	        	break;
	        default:
	        	imageLabelWeightError.setBounds(xI+225, yI-4, xoI, yoI);
	        	add(imageLabelWeightError);
	        }
	        newFieldWfOval = String.valueOf(format.format(wfOval));
	        if (wfOval < 0) {
	        	imageLabelWfErrorOval.setBounds(xI+102, yI+212, xoI, yoI);
		    	add(imageLabelWfErrorOval);
	        } else {
	        	imageLabelWfOval.setText(newFieldWfOval);
		    	imageLabelWfOval.setBounds(xI+102, yI+212, xoI, yoI);
		    	add(imageLabelWfOval);
	        }
	        newFieldGlass1 = String.valueOf(format.format(S2c));
	        if (S2c < 0) {
	        	imageLabelGlassError1.setBounds(xI+226, yI+212, xoI, yoI);
	        	add(imageLabelGlassError1);
	        } else {
		        switch (newFieldGlass1.length()) {
		        case 6:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+226, yI+212, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 7:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+222, yI+212, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 8:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+218, yI+212, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 9:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+214, yI+212, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 10:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+210, yI+212, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 11:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+206, yI+212, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        case 12:
		        	imageLabelGlass1.setText(newFieldGlass1);
		        	imageLabelGlass1.setBounds(xI+204, yI+212, xoI, yoI);
		        	add(imageLabelGlass1);
		        	break;
		        }
	        }
	        newFieldSealing = String.valueOf(1);
	        imageLabelSealingError.setText(newFieldSealing);
	        imageLabelSealingError.setBounds(xI+109, yI+58, xoI, yoI);
		    add(imageLabelSealingError);
	        break;
		}
		invalidate();
        validate();
        repaint();
	}
	
	/* Объявление отдельного класса для слушателя. */
	public class Actions implements ActionListener {
		
		/* Метод обработки событий всех кнопок, т.е. слушатель. */
		public void actionPerformed(ActionEvent e){
			/* Метод getActionCommand() возвращает команду(строку), установленную на кнопке */
			switch (e.getActionCommand()) {
			case "Рассчитать":
				tooLongError = false;
				switch (selectedType) {
				case 0:
					calculation(fieldCheck(fieldHeight.getText()),fieldCheck(fieldWeight.getText()));
					changeImage(1);
					break;
				case 1:
					calculation(fieldCheck(fieldRadius.getText()));
					changeImage(3);
					break;
				case 2:
					calculation(fieldCheck(fieldHeight.getText()),fieldCheck(fieldWeight.getText()),0);
					changeImage(5);
					break;
				}
				break;
			case "Принять":
				switch (comboBox1.getSelectedIndex()) {
				case 0: changeImage(0); break;
				case 1: changeImage(2); break;
				case 2: changeImage(4); break;
				}
				break;
			}
		}
	}
	
	/* Главный метод программы. С него начинается обработка команд. */
    public static void main(String args[]) {
        /* SwingUtilities.invokeLater предназначена для запуска асинхронной операции.
		 * Она сохраняет действие (Runnable), и запускает его на одной из следующих итераций цикла сообщений. */
		SwingUtilities.invokeLater(new Runnable() {
			/* Обращение к конструктору через метод. */
			public void run() {
				new CalcMain();
			}
		});
    }
    
}