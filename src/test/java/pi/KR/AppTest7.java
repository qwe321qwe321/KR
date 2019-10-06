package pi.KR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/* Метод, тестирующий вычисления ОК прямоугольного типа, используя метод assertEquals(),
 * принимающий в качестве параметров ответ (число) и число, возвращенное методом calculation(). */
public class AppTest1 {
	
	CalcMain api = new CalcMain();
	@Test
   	
	public void testApp() {
		assertEquals(806, api.calculation(25, 30));
	}
	
}
