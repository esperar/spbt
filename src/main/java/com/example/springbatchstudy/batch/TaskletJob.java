package com.example.springbatchstudy.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class TaskletJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job taskletJobBatchBuild() {
        return jobBuilderFactory.get("taskletJob")
                .start(taskletJobStep1())
                .build();
    }

    @Bean
    public Step taskletJobStep1() {
        return stepBuilderFactory.get("taskletJob_step1")
                .tasklet((a, b) -> {
                    log.debug("-> job -> step1");
                    return RepeatStatus.FINISHED;
                }).build();
    }
}