package com.example.springproj3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.ExecutionException;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class FirebaseTest {

    @Test
    public void testingSave() throws ExecutionException, InterruptedException {
        Architecture postedArchitecture = new Architecture("Basílica de la Sagrada Família", "Antoni Gaudí");
        ArchitectureService.saveArchitecture(postedArchitecture);

        Architecture theArch = ArchitectureService.getArchitectureInfo("Basílica de la Sagrada Família");

        assert theArch != null;
        assertEquals(postedArchitecture.name, theArch.name);
        assertEquals(postedArchitecture.architect, theArch.architect);
    }

}
