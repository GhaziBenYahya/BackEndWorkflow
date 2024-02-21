package com.insy2s.WorkflowService.service;

import com.insy2s.WorkflowService.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurService extends JpaRepository<Utilisateur, Long> {
}
