package br.com.tickets.codetickets;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportacaoJobConfiguration {

    private final JobRepository jobRepository;

    public ImportacaoJobConfiguration(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    
    public Job job(Step passoInicial, JobRepository jobRepository){
        return new JobBuilder("geracaoTickets", jobRepository)
                .start(passoInicial)
                .incrementer(new RunIdIncrementer())
                .build();

    }
}
