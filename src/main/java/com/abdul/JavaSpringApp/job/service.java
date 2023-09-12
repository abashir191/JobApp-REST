package com.abdul.JavaSpringApp.job;
import java.util.*;
public interface service {

    List<Job> allJobs();
    void addJobs(Job job);
    Job getJobById(Long id);

    boolean removeJobById(Long id);

    boolean update(Long id, Job updatedJob);
}
