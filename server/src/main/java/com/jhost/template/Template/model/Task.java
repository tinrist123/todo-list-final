package com.jhost.template.Template.model;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "task")
public class Task {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Id
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    private Long taskid;
    @Column(name = "userid")
    private Long userid;
    private String title;
    private String categorie;
    private String note;
    private int isDone;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createddate;
    @UpdateTimestamp
    private LocalDate updateddate;
    private LocalDate completedate;
}
