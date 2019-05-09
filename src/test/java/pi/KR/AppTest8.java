package pi.KR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest8 {
	
	CalcMain api = new CalcMain();
    @Test
    public void testApp() {
        assertEquals(961, api.calculation(30, 30));
    }
    
}
