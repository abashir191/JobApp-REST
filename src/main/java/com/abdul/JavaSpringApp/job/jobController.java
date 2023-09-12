package com.abdul.JavaSpringApp.job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class jobController {
   private service jobService;

    public jobController(service jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> allJobs(){
        return ResponseEntity.ok(jobService.allJobs());
    }
    @PostMapping("/jobs")
    public ResponseEntity<String> addJobs(@RequestBody Job job){
        jobService.addJobs(job);
        return new ResponseEntity<>("Successfully added job", HttpStatus.OK);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> removeJob(@PathVariable Long id){
        boolean removed = jobService.removeJobById(id);
        if(removed){
            return new ResponseEntity<>("Job removed successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.update(id, updatedJob);
        if(updated){
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
