package com.insy2s.WorkflowService.model;
import lombok.*;

import jakarta.persistence.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WorkflowExecutes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long WfExecutesId;
    private String CurrentStep;
    private String State;
    private String startDate;
    private String endDate;


    @OneToOne(mappedBy = "workflowExecutes")
    private Step step;

}
