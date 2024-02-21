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
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workflowId;
    private String workflowName;
    private String description;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime creationDate = LocalDateTime.now();


    private String responsible;

    @OneToMany(mappedBy = "workflow", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Ignorer la sérialisation de la collection steps
    private List<Step> steps = new ArrayList<>();





}
