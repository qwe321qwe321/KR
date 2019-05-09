package pi.KR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest3 {
	
	CalcMain api = new CalcMain();
    @Test
    public void testApp() {
        assertEquals(256, api.calculation(15, 15));
    }
    
}
