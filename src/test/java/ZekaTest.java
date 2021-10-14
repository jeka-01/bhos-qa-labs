import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZekaTest {
    @Test
    void Proofread(){
        Zeka task = new Zeka();
        Assertions.assertEquals(0, task.Hellos(20));
    }
}
