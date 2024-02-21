package com.insy2s.WorkflowService.controller;
import com.insy2s.WorkflowService.exception.ResourceNotFoundException;


import com.insy2s.WorkflowService.model.Conditional;
import com.insy2s.WorkflowService.model.Iterative;
import com.insy2s.WorkflowService.model.Step;
import com.insy2s.WorkflowService.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1/steps")
public class StepController {

    @Autowired
    private StepService stepService;

    @GetMapping
    public List<Step> getAllUSteps(){
        return stepService.findAll();
    }




    // build create Step REST API
    @PostMapping
    public Step createStep(@RequestBody Step step) {
        return stepService.save(step);
    }

    //



    // build get step by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Step> getStepById(@PathVariable long id){
        Step step = stepService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("step not exist with id:" + id));
        return ResponseEntity.ok(step);

    }





    // build update Step REST API
    @PutMapping("{id}")
    public ResponseEntity<Step> updateStep(@PathVariable long id,@RequestBody Step stepDetails) {
        Step updateStep = stepService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Step not exist with id: " + id));

        updateStep.setDescription(stepDetails.getDescription());
        updateStep.setName(stepDetails.getName());
        updateStep.setIdStepEntry(stepDetails.getIdStepEntry());
        updateStep.setIdStepExit(stepDetails.getIdStepExit());
        updateStep.setResult(stepDetails.getResult());


        updateStep.setWorkflow(stepDetails.getWorkflow());
        updateStep.setCreationDate(stepDetails.getCreationDate());

        stepService.save(updateStep);

        return ResponseEntity.ok(updateStep);
    }



    // build delete Step REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStep(@PathVariable long id){

        Step step = stepService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Step not exist with id: " + id));

        stepService.delete(step);



        String mes = "Step supprimé avec succès";

        return ResponseEntity.ok(mes);

    }

    //for conditional

    @PostMapping("/conditional")
    public ResponseEntity<?> createConditionalStep(@RequestBody Conditional conditionalStep) {

        stepService.save(conditionalStep);
        String mes = "Step conditional Ajouter avec succès";

        return ResponseEntity.ok(mes);
    }
    @PostMapping("/iterative")
    public ResponseEntity<?> createIterativeStep(@RequestBody Iterative iterativeStep) {

        stepService.save(iterativeStep);
        String mes = "Step iterative Ajouter avec succès";

        return ResponseEntity.ok(mes);
    }





}
