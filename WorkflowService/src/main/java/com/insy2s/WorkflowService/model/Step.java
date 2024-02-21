package com.insy2s.WorkflowService.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "step_type", discriminatorType = DiscriminatorType.STRING)
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stepId;
    private String name;
    private String description;
    private String result;
    private Long idStepEntry;
    private Long IdStepExit;
    private String responsible;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime creationDate = LocalDateTime.now();



    @ManyToOne
    @JoinColumn(name = "workflowId")
    private Workflow workflow;

    @OneToOne
    @JoinColumn(name = "workflow_executes_id", unique = true) // Nom de la clé étrangère dans la table Step
    private WorkflowExecutes workflowExecutes;










}
