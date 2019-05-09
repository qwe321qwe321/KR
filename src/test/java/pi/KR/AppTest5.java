package pi.KR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest5 {
	
	CalcMain api = new CalcMain();
    @Test
    public void testApp() {
        assertEquals(546, api.calculation(25, 20));
    }
    
}
