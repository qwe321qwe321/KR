package pi.KR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest4 {
	
	CalcMain api = new CalcMain();
    @Test
    public void testApp() {
        assertEquals(441, api.calculation(20, 20));
    }
    
}
