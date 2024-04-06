package cc.taketo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cc.taketo.mapper")
public class DataShardingApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataShardingApplication.class, args);
    }
}
