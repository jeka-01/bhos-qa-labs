import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PermissionManagerTest {
    @Test
    void Tests(){
        PermissionManager test = new PermissionManager();
        Assertions.assertEquals("ADMIN", test.returnLevel(PermissionManager.PermissionLevel.ADMIN));
        Assertions.assertEquals("USER", test.setLevel(PermissionManager.PermissionLevel.ADMIN));
    }
}
