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
 * в контексте операторов import и package – для доступа к вложенному пакету/объекту/классу,
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
 * JTextField thirdTextField = new JTextField("Третье текстовое поле"). */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
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
     * wfRectangle - площадь оконной рамы (Прямоугольная ОК)
     * wfRound - площадь оконной рамы (Круглая ОК)
     * wfOval - площадь оконной рамы (Овальная ОК)
     * selectedType - применяется для определения выбранного типа ОК в условии в слушателе кнопок actionPerformed()
     * (0 - Прямоугольная ОК, 1 - Круглая ОК, 2 - Овальная ОК) */
    final int x = 224; final int y = 10; final int xo = 99; final int yo = 29;
    final int xI = 82; final int yI = 200; final int xoI = 100; final int yoI = 29;
    int S1c; double S2c; int wfRectangle; double wfRound; double wfOval; byte selectedType = 0;
    
    /* Инициализация всех объектов.
     * 
     * Верхняя область окна содержит следующие объекты:
     * JLabel, принимающие в качестве параметра строки текста - labelType, labelHeight, labelWeight,
     * labelRadius, labelMaterial, labelSealing, labelAnswer1, labelAnswer2 labelAnswer3, labelAnswer4;
     * JTextField - fieldHeight, fieldWeight, fieldRadius;
     * JComboBox, принимающие в качестве параметра массивы строк - comboBox1, comboBox2, comboBox3;
     * JButton - buttonType, buttonCalculate.
     * 
     * Нижняя область окна содержит следующие объекты:
     * JLabel, принимающие в качестве параметра экземпляры ImageIcon - rectangleDefaultImageJLabel, rectangleImageJLabel,
     * roundDefaultImageJLabel, roundImageJLabel, ovalDefaultImageJLabel, ovalImageJLabel;
     * JLabel, принимающие в качестве параметра строки текста - imageLabelHeight, imageLabelHeightError, imageLabelWeight,
     * imageLabelWeightError, imageLabelRadius, imageLabelRadiusError, imageLabelGlass1, imageLabelGlassError1, imageLabelGlass2,
     * imageLabelGlassError2, imageLabelSealing, imageLabelSealingError, imageLabelWfRec, imageLabelWfErrorRec,
     * imageLabelWfRound, imageLabelWfErrorRound, imageLabelWfOval, imageLabelWfErrorOval.
     * 
     * Прочие параметры:
     * format - экземпляр класса DecimalFormat, в качестве параметра содержит форматирование;
     * error - строка со словом "Error", применяется для объектов со словом Error в конце их имени;
     * tooLongError - применяется для проверки на переполнение в условиях в методе calculation();
     * imageStringHeight - строка со значением высоты, полученным после проверки и вычисления;
     * imageStringWeight - строка со значением ширины, полученным после проверки и вычисления;
     * imageStringRadius - строка со значением радиуса, полученным после проверки и вычисления;
     * imageStringGlass1 - строка со значением площади первого стекла, полученным после проверки и вычисления;
     * imageStringGlass2 - строка со значением площади второго стекла, полученным после проверки и вычисления;
     * imageStringSealing - строка со значением площади уплотнения, полученным после проверки и вычисления;
     * imageStringWfRectangle - строка со значением площади оконной рамы, полученным после проверки и вычисления (Прямоугольная ОК);
     * imageStringWfRound - строка со значением площади оконной рамы, полученным после проверки и вычисления (Круглая ОК);
     * imageStringWfOval - строка со значением площади оконной рамы, полученным после проверки и вычисления (Овальная ОК). */
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
    JLabel imageLabelHeight = new JLabel(); JLabel imageLabelHeightError = new JLabel(error); String imageStringHeight;
    JLabel imageLabelWeight = new JLabel(); JLabel imageLabelWeightError = new JLabel(error); String imageStringWeight;
    JLabel imageLabelRadius = new JLabel(); JLabel imageLabelRadiusError = new JLabel(error); String imageStringRadius;
    JLabel imageLabelGlass1 = new JLabel(); JLabel imageLabelGlassError1 = new JLabel(error); String imageStringGlass1;
    JLabel imageLabelGlass2 = new JLabel(); JLabel imageLabelGlassError2 = new JLabel(error); String imageStringGlass2;
    JLabel imageLabelSealing = new JLabel(); JLabel imageLabelSealingError = new JLabel(error); String imageStringSealing;
    JLabel imageLabelWfRectangle = new JLabel(); JLabel imageLabelErrorWfRectangle = new JLabel(error); String imageStringWfRectangle;
    JLabel imageLabelWfRound = new JLabel(); JLabel imageLabelErrorWfRound = new JLabel(error); String imageStringWfRound;
    JLabel imageLabelWfOval = new JLabel(); JLabel imageLabelErrorWfOval = new JLabel(error); String imageStringWfOval;
    JLabel rectangleDefaultImageJLabel = new JLabel(catchPathException((byte)0));
    JLabel rectangleImageJLabel = new JLabel(catchPathException((byte)1));
    JLabel roundDefaultImageJLabel = new JLabel(catchPathException((byte)2));
    JLabel roundImageJLabel = new JLabel(catchPathException((byte)3));
    JLabel ovalDefaultImageJLabel = new JLabel(catchPathException((byte)4));
    JLabel ovalImageJLabel = new JLabel(catchPathException((byte)5));
    JTextField fieldHeight = new JTextField(10);
    JTextField fieldWeight = new JTextField(10);
    JTextField fieldRadius = new JTextField(10);
    JButton buttonCalculate = new JButton("Рассчитать");
    JButton buttonType = new JButton("Принять");
    String[] comboTypes = {"Прямоугольная", "Круглая", "Овальная"};
    String[] comboMaterial = {"Дерево", "Алюминий", "ПВХ"};
    String[] comboSealing = {"Резиновое"};
    JComboBox<String> comboBoxTypes = new JComboBox<String>(comboTypes);
    JComboBox<String> comboBoxMaterial = new JComboBox<String>(comboMaterial);
    JComboBox<String> comboBoxSealing = new JComboBox<String>(comboSealing);
    DecimalFormat format = new DecimalFormat("##.00");
	
	/* Конструктор CalcMain(). Конструктор – это метод класса, который инициализирует новый объект после его создания.
	 * В данном случае, при вызове конструктора вызываются методы super() и createGUI().
	 * Метод super() – это вызов конструктора класса JFrame, в качестве параметра может принимать строку текста,
	 * впоследствии установит её в качестве заголовка окна.
	 * Имя конструктора всегда совпадает с именем класса, в котором он расположен.
	 * У конструкторов нет типа возвращаемого результата - никакого, даже void.
	 * Суть его использования в том, что не всегда удобно инициализировать все переменные класса при создании его экземпляра.
	 * Иногда проще, чтобы какие-то значения были бы созданы по умолчанию при создании объекта.
	 * Т.е. конструктор нужен для автоматической инициализации переменных.
	 * Соответственно, в данном случае, вызов конструктора всегда инициирует создание нового окна с заголовком "Расчет оконной конструкции".
	 * */
	public CalcMain() {
		super("Расчет оконной конструкции");
		createGUI();
    }
	
	/* Метод createGUI() используется для инициализации окна и расположения на нем графических объектов. */
	public void createGUI() {
		/* Метод setDefaultCloseOperation() устанавливает условие, при котором окно будет закрыто.
		 * Константа EXIT_ON_CLOSE указывает на то, что окно будет закрыто при нажатии кнопки 'Закрыть' (Close Box). */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/* Метод setSize() устанавливает размер окна, принимая значения высоты и ширины в пикселях. */
        setSize(663,700);
        /* Метод setLocationRelativeTo() устанавливает позицию окна на экране.
         * Значение null указывает на то, что окно будет помещено в центре экрана относительно центра окна. */
        setLocationRelativeTo(null);
        /* Метод setVisible() устанавливает (не)видимость окна на экране.
         * Значение true указывает на то, что окно станет видимым. */
        setVisible(true);
        /* Метод setResizable() устанавливает возможность изменения размера окна вручную пользователем.
         * Значение false указывает на то, что изменение размера окна будет запрещено. */
        setResizable(false);
        /* Метод setBounds() устанавливает координаты объекта, add() - добавляет объект на окно,
         * setActionCommand() - устанавливает команду для идентификации кнопки слушателем actionPerformed(). */
        labelType.setBounds(x-199, y, xo+99, yo+1);
        labelHeight.setBounds(x+13, y, xo+1, yo+1);
        labelWeight.setBounds(x+113, y, xo+1, yo+1);
        labelRadius.setBounds(x+67, y, xo+1, yo+1);
        labelMaterial.setBounds(x+220, y, xo+1, yo+1);
        labelSealing.setBounds(x+313, y, xo+1, yo+1);
        labelAnswer1.setBounds(x-199, y+93, xo+301, yo+1);
        labelAnswer2.setBounds(x-157, y+113, xo+301, yo+1);
        labelAnswer3.setBounds(x-157, y+133, xo+301, yo+1);
        labelAnswer4.setBounds(x-157, y+153, xo+301, yo+1);
        fieldHeight.setBounds(x, y+33, xo+1, yo+1);
        fieldWeight.setBounds(x+100, y+33, xo+1, yo+1);
        fieldRadius.setBounds(x, y+33, xo+101, yo+1);
        comboBoxTypes.setBounds(x-199, y+33, xo+99, yo);
        comboBoxMaterial.setBounds(x+200, y+33, xo, yo);
        comboBoxSealing.setBounds(x+300, y+33, xo, yo);
        buttonType.setBounds(x-199, y+63, xo+99, yo+1);
        buttonType.setActionCommand("Принять");
        buttonCalculate.setBounds(x, y+63, xo+300, yo+1);
        buttonCalculate.setActionCommand("Рассчитать");
        
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
        add(comboBoxTypes);
        add(comboBoxMaterial);
        add(comboBoxSealing);
        add(buttonType);
        add(buttonCalculate);
        add(rectangleDefaultImageJLabel);
        
        /* Инициализация объекта actionListener интерфейса ActionListener через реализующий класс Actions(). */
        ActionListener actionListener = new Actions();
        /* Установка слушателя на кнопки через объект. */
        buttonCalculate.addActionListener(actionListener);
        buttonType.addActionListener(actionListener);
	}
	
    /* Метод calculation() – перегруженный метод расчета оконной конструкции, в данном случае - Прямоугольной. */
	public int calculation(int h, int w) {
		/* Внешним переменным присваивается отрицательное значение, которое будет изменено на некоторое
		 * положительное в случае, если будущее значение, передаваемое переменным, пройдет проверку. */
		S1c = -1; wfRectangle = -1; int forTest = 0;
		labelAnswer2.setText(""); labelAnswer3.setText(""); labelAnswer4.setText("");
		if (tooLongError == true) labelAnswer1.setText("(Значение одного или всех полей слишком длинное)");
		else if ((h == 0) || (w == 0)) labelAnswer1.setText("(Одно или все поля заполнены некорректно)");
		else {
			/* S - площадь ОК без уплотнения, So - общая площадь ОК, S1c - площадь 1-го стекла в многостекольной ОК,
			 * Sr - площадь оконной рамы, Su - площадь уплотнения, Soc - площадь остекления,
			 * h - высота, w - ширина, r - ширина оконной рамы, u - ширина внешнего уплотнения ОК. */
			int S; int So; int Sr; int Su; int Soc; int u = 1; int r = comboBox2Check();
			S = h*w;
			So = (h+u)*(w+u);
			Sr = h*3*r+(w-3*r)*2;
			if (Sr > 0) wfRectangle = Sr;
			Su = So-S;
			Soc = So-Su-Sr;
			if (Soc > 0) S1c = Soc/2;
			forTest = So;
			if (So < 0) labelAnswer1.setText("Ответ: "+error+" (Общая площадь оконной конструкции)");
			else labelAnswer1.setText("Ответ: "+So+" см^2 (Общая площадь оконной конструкции)");
			if (Sr < 0) labelAnswer2.setText(error+" (Площадь оконной рамы)");
			else labelAnswer2.setText(Sr+" см^2 (Площадь оконной рамы)");
			if (Su < 0) labelAnswer3.setText(error+" (Площадь уплотнения)");
			else labelAnswer3.setText(Su+" см^2 (Площадь уплотнения)");
			if (Soc < 0) labelAnswer4.setText(error+" (Площадь остекления)");
			else labelAnswer4.setText(Soc+" см^2 (Площадь остекления)");
		}
		return forTest;
	}
	
	/* Метод calculation() – перегруженный метод расчета оконной конструкции, в данном случае - Круглой. */
	public void calculation(int rad) {
		/* Внешним переменным присваивается отрицательное значение, которое будет изменено на некоторое
		 * положительное в случае, если будущее значение, передаваемое переменным, пройдет проверку. */
		S2c = -1; wfRound = -1;
		labelAnswer2.setText(""); labelAnswer3.setText(""); labelAnswer4.setText("");
		if (tooLongError == true) labelAnswer1.setText("(Значение в поле 'Радиус' слишком длинное)");
		else if ((rad == 0)) labelAnswer1.setText("(Поле 'Радиус' заполнено некорректно)");
		else {
			/* S - Площадь ОК без уплотнения, So - Общая площадь ОК, Sr - Площадь оконной рамы, Su - Площадь уплотнения,
			 * Soc - Площадь остекления, rad - радиус, r - ширина оконной рамы, u - ширина внешнего уплотнения ОК. */
			double S; double So; double Sr; double Su; double Soc; double u = 1; int r = comboBox2Check();
			S = Math.PI*Math.pow(rad, 2);
			So = Math.PI*Math.pow(rad+u, 2);
			Sr = S-Math.PI*Math.pow((rad-r), 2);
			if (Sr > 0) wfRound = Sr;
			Su = So-S;
			Soc = So-Su-Sr;
			if (Soc > 0) S2c = Soc;
			if (So < 0) labelAnswer1.setText("Ответ: "+error+" (Общая площадь оконной конструкции)");
			else labelAnswer1.setText("Ответ: "+format.format(So)+" см^2 (Общая площадь оконной конструкции)");
			if (Sr < 0) labelAnswer2.setText(error+" (Площадь оконной рамы)");
			else labelAnswer2.setText(format.format(Sr)+" см^2 (Площадь оконной рамы)");
			if (Su < 0) labelAnswer3.setText(error+" (Площадь уплотнения)");
			else labelAnswer3.setText(format.format(Su)+" см^2 (Площадь уплотнения)");
			if (Soc < 0) labelAnswer4.setText(error+" (Площадь остекления)");
			else labelAnswer4.setText(format.format(Soc)+" см^2 (Площадь остекления)");
		}
	}
	
	/* Метод calculation() – перегруженный метод расчета оконной конструкции, в данном случае - Овальной. */
	public void calculation(int h, int w, byte nothing) {
		/* Внешним переменным присваивается отрицательное значение, которое будет изменено на некоторое
		 * положительное в случае, если будущее значение, передаваемое переменным, пройдет проверку. */
		S2c = -1; wfOval = -1;
		labelAnswer2.setText(""); labelAnswer3.setText(""); labelAnswer4.setText("");
		if (tooLongError == true) labelAnswer1.setText("(Значение одного или всех полей слишком длинное)");
		else if ((h == 0) || (w == 0)) labelAnswer1.setText("(Одно или все поля заполнены некорректно)");
		else {
			/* S - Площадь ОК без уплотнения, So - Общая площадь ОК, Sr - Площадь оконной рамы, Su - Площадь уплотнения,
			 * Soc - Площадь остекления, h - высота, w - ширина, r - ширина оконной рамы, u - ширина внешнего уплотнения ОК. */
			double S; double So; double Sr; double Su; double Soc; double u = 1; int r = comboBox2Check();
			S = Math.PI*h*w;
			So = Math.PI*(h+2*u)*(w+2*u);
			Soc = Math.PI*(h-2*r)*(w-2*r);
			if (Soc > 0) S2c = Soc;
			Su = So-S;
			Sr = S-Soc;
			if (Sr > 0) wfOval = Sr;
			if (So < 0) labelAnswer1.setText("Ответ: "+error+" (Общая площадь оконной конструкции)");
			else labelAnswer1.setText("Ответ: "+format.format(So)+" см^2 (Общая площадь оконной конструкции)");
			if (Sr < 0) labelAnswer2.setText(error+" (Площадь оконной рамы)");
			else labelAnswer2.setText(format.format(Sr)+" см^2 (Площадь оконной рамы)");
			if (Su < 0) labelAnswer3.setText(error+" (Площадь уплотнения)");
			else labelAnswer3.setText(format.format(Su)+" см^2 (Площадь уплотнения)");
			if (Soc < 0) labelAnswer4.setText(error+" (Площадь остекления)");
			else labelAnswer4.setText(format.format(Soc)+" см^2 (Площадь остекления)");
		}
	}
	
	/* Метод fieldCheck() проверяет строку (поле) на ввод числа и переполнение. */
	public int fieldCheck(String word) {
		/* Инициализация переменной вывода. */
		int zero = 0;
		/* Условие проверяет длину принятого полем слова:
		 * Если она равна нулю, работа метода fieldCheck() прекращается и он возвращает ноль. */
		if (word.length() == 0) return zero;
		else {
			/* Разбиение принятого полем слова на отдельные символы для посимвольной проверки. */
			char[] aword = word.toCharArray();
			/* Инициализация нового слова, в которое будут добавлены символы, прошедшие проверку. */
			String notZero = "0";
			/* В цикле проверяется условие соответствия символа цифре, при совпадении добавляет символ в новое слово. */
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
			/* Установка значения true переменной проверки в случае, если она больше числа 9999.
			 * Это значит, что принятое методом fieldCheck() слово не прошло проверку. */
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
		switch (comboBoxMaterial.getSelectedIndex()) {
		case 0: windowFrameWidth = 10; break;
		case 1:	windowFrameWidth = 5; break;
		case 2:	windowFrameWidth = 6; break;
		}
		return windowFrameWidth;
	}
	
	/* Метод catchPath() предназначен для проверки исключения NullPointerException при попытке присвоения экземпляру URL
	 * некоторой ссылки. Исключение может возникнуть в случае, если файл, на который ссылается экземпляр, был перемещен,
	 * удален, было изменено его имя и т.п. Т.е. в этом случае экземпляру будет присвоена ссылка на 'несуществующий' файл.
	 * В теле метода catchPath() сначала выполняется условие switch-case, в котором проверяется, какую именно проверку
	 * необходимо выполнить, путем считывания входного параметра: 0, 1, 2, 3, 4, 5.
	 * После чего выполняется конструкция try-catch, в теле которой сначала идет инициализация экземпляра URL и
	 * попытка присвоения ему ссылки на файл, за которой, при успешном присвоении, следует инициализация экземпляра
	 * ImageIcon с экземпляром URL в качестве параметра и вывод экземпляра ImageIcon методом catchPath().
	 * (1) В случае возникновения исключения иницализация экземпляра URL пропускается, после чего экземпляр ImageIcon
	 * инициализируется со значением по умолчанию, после чего следует возвращение экзмепляра ImageIcon методом catchPath().
	 * В случае вызова метода catchPath() с входным параметром, не учитываемым в условии switch-case, выполняется
	 * инструкция, аналогичная возникновению исключения, т.е. (1). */
	public ImageIcon catchPathException(byte selected) {
		switch (selected) {
		case 0:
			try {
				URL imgURL = CalcMain.class.getResource("RectangleWindowDefault.png");
				ImageIcon RectangleWindowDefault = new ImageIcon(imgURL);
				return RectangleWindowDefault;
			} catch(NullPointerException e) {
				ImageIcon RectangleWindowDefault = new ImageIcon();
				return RectangleWindowDefault;
			}
		case 1:
			try {
				URL imgURL = CalcMain.class.getResource("RectangleWindow.png");
				ImageIcon RectangleWindowDefault = new ImageIcon(imgURL);
				return RectangleWindowDefault;
			} catch(NullPointerException e) {
				ImageIcon RectangleWindowDefault = new ImageIcon();
				return RectangleWindowDefault;
			}
		case 2:
			try {
				URL imgURL = CalcMain.class.getResource("RoundWindowDefault.png");
				ImageIcon RectangleWindowDefault = new ImageIcon(imgURL);
				return RectangleWindowDefault;
			} catch(NullPointerException e) {
				ImageIcon RectangleWindowDefault = new ImageIcon();
				return RectangleWindowDefault;
			}
		case 3:
			try {
				URL imgURL = CalcMain.class.getResource("RoundWindow.png");
				ImageIcon RectangleWindowDefault = new ImageIcon(imgURL);
				return RectangleWindowDefault;
			} catch(NullPointerException e) {
				ImageIcon RectangleWindowDefault = new ImageIcon();
				return RectangleWindowDefault;
			}
		case 4:
			try {
				URL imgURL = CalcMain.class.getResource("OvalWindowDefault.png");
				ImageIcon RectangleWindowDefault = new ImageIcon(imgURL);
				return RectangleWindowDefault;
			} catch(NullPointerException e) {
				ImageIcon RectangleWindowDefault = new ImageIcon();
				return RectangleWindowDefault;
			}
		case 5:
			try {
				URL imgURL = CalcMain.class.getResource("OvalWindow.png");
				ImageIcon RectangleWindowDefault = new ImageIcon(imgURL);
				return RectangleWindowDefault;
			} catch(NullPointerException e) {
				ImageIcon RectangleWindowDefault = new ImageIcon();
				return RectangleWindowDefault;
			}
		default:
			ImageIcon RectangleWindowDefault = new ImageIcon();
			return RectangleWindowDefault;
		}
	}
	
	/* Метод removeWaste() предназначен для очистки окна JFrame от ненужных JLabel и JField. Используется в методе changeFrame().
	 * Метод remove() удаляет объект с окна JFrame, принимая в качестве параметра ссылку на объект. */
	public void removeWaste() {
		remove(labelHeight);
		remove(labelWeight);
		remove(labelRadius);
		remove(fieldHeight);
		remove(fieldWeight);
		remove(fieldRadius);
		remove(imageLabelHeight);
		remove(imageLabelHeightError);
		remove(imageLabelWeight);
		remove(imageLabelWeightError);
		remove(imageLabelRadius);
		remove(imageLabelRadiusError);
		remove(imageLabelGlass1);
		remove(imageLabelGlassError1);
		remove(imageLabelGlass2);
		remove(imageLabelGlassError2);
		remove(imageLabelSealing);
		remove(imageLabelSealingError);
		remove(imageLabelWfRectangle);
		remove(imageLabelErrorWfRectangle);
		remove(imageLabelWfRound);
		remove(imageLabelErrorWfRound);
		remove(imageLabelWfOval);
		remove(imageLabelErrorWfOval);
		remove(labelAnswer1);
		remove(labelAnswer2);
		remove(labelAnswer3);
		remove(labelAnswer4);
		remove(rectangleDefaultImageJLabel);
		remove(rectangleImageJLabel);
		remove(roundDefaultImageJLabel);
		remove(roundImageJLabel);
		remove(ovalDefaultImageJLabel);
		remove(ovalImageJLabel);
	}
	
	/* Метод changeFrame() используется в слушателе actionPerformed().
	 * Он производит замену изображения и перестановку объектов в зависимости от входного параметра:
	 * 0 – означает нажатие кнопки 'Рассчитать' (buttonCalculate), если выбран прямоугольный тип ОК,
	 * 1 – означает нажатие кнопки 'Принять' (buttonType), если выбран прямоугольный тип ОК,
	 * 2 – означает нажатие кнопки 'Рассчитать' (buttonCalculate), если выбран круглый тип ОК,
	 * 3 – означает нажатие кнопки 'Принять' (buttonType), если выбран круглый тип ОК,
	 * 4 – означает нажатие кнопки 'Рассчитать' (buttonCalculate), если выбран овальный тип ОК,
	 * 5 – означает нажатие кнопки 'Принять' (buttonType), если выбран овальный тип ОК. */
	public void changeFrame(int selected) {
		switch (selected) {
		case 0:
			selectedType = 0;
			removeWaste();
			add(labelHeight);
			add(labelWeight);
			add(fieldHeight); fieldHeight.setText("");
			add(fieldWeight); fieldWeight.setText("");
			add(rectangleDefaultImageJLabel);
	        break;
		case 1:
			removeWaste();
			add(labelHeight);
			add(labelWeight);
			add(fieldHeight);
			add(fieldWeight);
			add(labelAnswer1);
			add(labelAnswer2);
			add(labelAnswer3);
			add(labelAnswer4);
	        imageStringHeight = String.valueOf(fieldCheck(fieldHeight.getText()));
	        fieldHeight.setText(imageStringHeight);
	        if (0 < imageStringHeight.length() & imageStringHeight.length() < 5) {
	        	imageLabelHeight.setText(imageStringHeight);
	        	imageLabelHeight.setBounds(xI+17-(4*imageStringHeight.length()), yI+223, xoI, yoI);
	        	add(imageLabelHeight);
	        } else {
	        	imageLabelHeightError.setBounds(xI, yI+223, xoI, yoI);
	        	add(imageLabelHeightError);
	        }
	        imageStringWeight = String.valueOf(fieldCheck(fieldWeight.getText()));
	        fieldWeight.setText(imageStringWeight);
	        if (0 < imageStringWeight.length() & imageStringWeight.length() < 5) {
	        	imageLabelWeight.setText(imageStringWeight);
	        	imageLabelWeight.setBounds(xI+249-(4*imageStringWeight.length()), yI, xoI, yoI);
	        	add(imageLabelWeight);
	        } else {
	        	imageLabelWeightError.setBounds(xI+233, yI, xoI, yoI);
	        	add(imageLabelWeightError);
	        }
	        if (S1c < 0) {
	        	imageLabelGlassError1.setBounds(xI+140, yI+223, xoI, yoI);
	        	add(imageLabelGlassError1);
	        	imageLabelGlassError2.setBounds(xI+332, yI+223, xoI, yoI);
	        	add(imageLabelGlassError2);
	        } else {
		        imageStringGlass1 = String.valueOf(S1c);
		        if (0 < imageStringGlass1.length() & imageStringGlass1.length() < 9) {
		        	imageLabelGlass1.setText(imageStringGlass1);
		        	imageLabelGlass1.setBounds(xI+154-(4*imageStringGlass1.length()), yI+223, xoI, yoI);
		        	add(imageLabelGlass1);
		        } else {
		        	imageLabelGlassError1.setBounds(xI+140, yI+223, xoI, yoI);
		        	add(imageLabelGlassError1);
		        }
		        imageStringGlass2 = String.valueOf(S1c);
		        if (0 < imageStringGlass2.length() & imageStringGlass2.length() < 9) {
		        	imageLabelGlass2.setText(imageStringGlass2);
		        	imageLabelGlass2.setBounds(xI+348-(4*imageStringGlass2.length()), yI+223, xoI, yoI);
		        	add(imageLabelGlass2);
		        } else {
		        	imageLabelGlassError2.setBounds(xI+332, yI+223, xoI, yoI);
		        	add(imageLabelGlassError2);
		        }
	        }
	        imageStringWfRectangle = String.valueOf(wfRectangle);
	        if (wfRectangle < 0) {
	        	imageLabelErrorWfRectangle.setBounds(xI+58, yI+223, xoI, yoI);
		    	add(imageLabelErrorWfRectangle);
	        } else {
	        	imageLabelWfRectangle.setText(imageStringWfRectangle);
		    	imageLabelWfRectangle.setBounds(xI+58, yI+223, xoI, yoI);
		    	add(imageLabelWfRectangle);
	        }
	        imageStringSealing = String.valueOf(1);
	        imageLabelSealing.setText(imageStringSealing);
	        imageLabelSealing.setBounds(xI+31, yI, xoI, yoI);
		    add(imageLabelSealing);
		    add(rectangleImageJLabel);
	        break;
		case 2:
			selectedType = 1;
			removeWaste();
			add(labelRadius);
			add(fieldRadius); fieldRadius.setText("");
			add(roundDefaultImageJLabel);
			break;
		case 3:
			removeWaste();
			add(labelRadius);
			add(fieldRadius);
			add(labelAnswer1);
			add(labelAnswer2);
			add(labelAnswer3);
			add(labelAnswer4);
			imageStringRadius = String.valueOf(fieldCheck(fieldRadius.getText()));
	        fieldRadius.setText(imageStringRadius);
	        if (imageStringRadius.length() > 4) {
	        	imageLabelRadiusError.setBounds(xI+250, yI+109, xoI, yoI);
	        	add(imageLabelRadiusError);
	        } else {
	        	imageLabelRadius.setText(imageStringRadius);
	        	imageLabelRadius.setBounds(xI+250, yI+109, xoI, yoI);
	        	add(imageLabelRadius);
	        }
	        if (wfRound < 0) {
	        	imageLabelErrorWfRound.setBounds(xI+230, yI+23, xoI, yoI);
	        	add(imageLabelErrorWfRound);
	        } else {
		        imageStringWfRound = String.valueOf(format.format(wfRound));
		        if (0 < imageStringWfRound.length() & imageStringWfRound.length() < 10) {
		        	imageLabelWfRound.setText(imageStringWfRound);
			    	imageLabelWfRound.setBounds(xI+250-(4*imageStringWfRound.length()), yI+23, xoI, yoI);
			    	add(imageLabelWfRound);
		        } else {
		        	imageLabelErrorWfRound.setBounds(xI+230, yI+23, xoI, yoI);
		        	add(imageLabelErrorWfRound);
		        }
	        }
	        imageStringGlass1 = String.valueOf(format.format(S2c));
	        if (S2c < 0) {
	        	imageLabelGlassError1.setBounds(xI+251, yI+214, xoI, yoI);
	        	add(imageLabelGlassError1);
	        } else {
		        imageLabelGlass1.setText(imageStringGlass1);
		        imageLabelGlass1.setBounds(xI+250, yI+214, xoI, yoI);
		        add(imageLabelGlass1);
		    }
	        imageStringSealing = String.valueOf(1);
	        imageLabelSealing.setText(imageStringSealing);
	        imageLabelSealing.setBounds(xI+70, yI+48, xoI, yoI);
		    add(imageLabelSealing);
		    add(roundImageJLabel);
			break;
		case 4:
			selectedType = 2;
			removeWaste();
			add(labelHeight);
			add(labelWeight);
			add(fieldHeight); fieldHeight.setText("");
			add(fieldWeight); fieldWeight.setText("");
			add(ovalDefaultImageJLabel);
	        break;
		case 5:
			removeWaste();
			add(labelHeight);
			add(labelWeight);
			add(fieldHeight);
			add(fieldWeight);
			add(labelAnswer1);
			add(labelAnswer2);
			add(labelAnswer3);
			add(labelAnswer4);
	        imageStringHeight = String.valueOf(fieldCheck(fieldHeight.getText()));
	        fieldHeight.setText(imageStringHeight);
	        if (0 < imageStringHeight.length() & imageStringHeight.length() < 5) {
	        	imageLabelHeight.setText(imageStringHeight);
	        	imageLabelHeight.setBounds(xI+71-(6*imageStringHeight.length()), yI+212, xoI, yoI);
	        	add(imageLabelHeight);
	        } else {
	        	imageLabelHeightError.setBounds(xI+46, yI+212, xoI, yoI);
	        	add(imageLabelHeightError);
	        }
	        imageStringWeight = String.valueOf(fieldCheck(fieldWeight.getText()));
	        fieldWeight.setText(imageStringWeight);
	        if (0 < imageStringWeight.length() & imageStringWeight.length() < 5) {
	        	imageLabelWeight.setText(imageStringWeight);
	        	imageLabelWeight.setBounds(xI+241-(4*imageStringWeight.length()), yI-4, xoI, yoI);
	        	add(imageLabelWeight);
	        } else {
	        	imageLabelWeightError.setBounds(xI+225, yI-4, xoI, yoI);
	        	add(imageLabelWeightError);
	        }
	        imageStringWfOval = String.valueOf(format.format(wfOval));
	        if (wfOval < 0) {
	        	imageLabelErrorWfOval.setBounds(xI+102, yI+212, xoI, yoI);
		    	add(imageLabelErrorWfOval);
	        } else {
	        	imageLabelWfOval.setText(imageStringWfOval);
		    	imageLabelWfOval.setBounds(xI+102, yI+212, xoI, yoI);
		    	add(imageLabelWfOval);
	        }
	        imageStringGlass1 = String.valueOf(format.format(S2c));
	        if (S2c < 0) {
	        	imageLabelGlassError1.setBounds(xI+226, yI+212, xoI, yoI);
	        	add(imageLabelGlassError1);
	        } else {
	        	if (0 < imageStringGlass1.length() & imageStringGlass1.length() < 13) {
		        	imageLabelGlass1.setText(imageStringGlass1);
		        	imageLabelGlass1.setBounds(xI+250-(4*imageStringGlass1.length()), yI+212, xoI, yoI);
		        	add(imageLabelGlass1);
		        }
	        }
	        imageStringSealing = String.valueOf(1);
	        imageLabelSealing.setText(imageStringSealing);
	        imageLabelSealing.setBounds(xI+109, yI+58, xoI, yoI);
		    add(imageLabelSealing);
		    add(ovalImageJLabel);
	        break;
		}
		/* Метод invalidate() помечает контейнер (JFrame) как недействительный.
		 * Под этим понимается, что контейнер содержит что-то ненужное или дефективное, что должно быть изменено. */
		invalidate();
		/* Метод validate() помечает контейнер (JFrame) как действительный и инициализирует изменения. */
        validate();
        /* Метод repaint() перерисовывает окно. */
        repaint();
	}
	
	/* Инициализация класса, реализующего интерфейс ActionListener через метод actionPerformed(). */
	public class Actions implements ActionListener {
		
		/* Метод обработки событий всех кнопок, т.е. слушатель. В качестве параметра принимает событие ActionEvent. */
		public void actionPerformed(ActionEvent e){
			/* Метод getActionCommand() возвращает команду(строку), установленную на кнопке. */
			switch (e.getActionCommand()) {
			case "Рассчитать":
				/* Сброс значения переменной проверки необходим перед началом расчета. В противном случае, после возникновения
				 * ошибки в какой-либо переменной, повторный расчет не будет произведен, даже если ошибка больше не возникает. */
				tooLongError = false;
				/* С помощью переменной selectedType условие проверяет, какой тип ОК был выбран (0 - Прямоугольный, 1 - Круглый,
				 * 2 - Овальный) и, в зависимости от него, вызывает определенный перегруженный метод calculation(). */
				switch (selectedType) {
				case 0:
					calculation(fieldCheck(fieldHeight.getText()),fieldCheck(fieldWeight.getText()));
					changeFrame(1);
					break;
				case 1:
					calculation(fieldCheck(fieldRadius.getText()));
					changeFrame(3);
					break;
				case 2:
					calculation(fieldCheck(fieldHeight.getText()),fieldCheck(fieldWeight.getText()),(byte)0);
					changeFrame(5);
					break;
				}
				break;
			case "Принять":
				switch (comboBoxTypes.getSelectedIndex()) {
				case 0: changeFrame(0); break;
				case 1: changeFrame(2); break;
				case 2: changeFrame(4); break;
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
			/* Вызов конструктора в методе run(). */
			public void run() {
				new CalcMain();
			}
		});
    }
    
}
