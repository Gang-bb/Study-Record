package com.gangbb.chapter05.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @author : Gangbb
 * @ClassName : AppProperties
 * @Description :
 * @Date : 2021/3/5 14:25
 */
@Validated
@Configuration
@ConfigurationProperties(prefix = "gangbb")
public class AppProperties {
    @Getter
    @Setter
    @Valid
    private Jwt jwt = new Jwt();

    @Getter
    @Setter
    public static class Jwt {

        private String header = "Authorization"; // HTTP 报头的认证字段的 key

        private String prefix = "Bearer "; // HTTP 报头的认证字段的值的前缀

        @Min(5000L)
        private long accessTokenExpireTime = 60 * 1000L; // Access Token 过期时间

        @Min(3600000L)
        private long refreshTokenExpireTime = 30 * 24 * 3600 * 1000L; // Refresh Token 过期时间
    }
}

