package com.gitprism.GitPRism.testcontroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Test API", description = "Swagger 테스트 API")
public class TestController {

    @Operation(summary = "테스트 엔드포인트", description = "Swagger 연동을 테스트하는 API입니다.")
    @GetMapping("/test")
    public String test() {
        return "Swagger 연동 성공!";
    }
}
