package com.example.springproj3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController

@RequestMapping("/api")

public class ArchitectureController {

    @Autowired
    ArchitectureService architectureService;

    @PostMapping("/architectures")
    public String saveArchitecture(@RequestBody Architecture architecture) throws ExecutionException, InterruptedException {

        return ArchitectureService.saveArchitecture(architecture);

    }

    @GetMapping("/architectures/{name}")
    public Architecture getArchitectureInfo(@PathVariable String name) throws ExecutionException, InterruptedException {

        return ArchitectureService.getArchitectureInfo(name);

    }

}
