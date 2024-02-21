package com.insy2s.WorkflowService.controller;

import com.insy2s.WorkflowService.exception.ResourceNotFoundException;
import com.insy2s.WorkflowService.model.Utilisateur;
import com.insy2s.WorkflowService.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.findAll();
    }




    // build create utilisateur REST API
    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.save(utilisateur);
    }



    // build get utilisateur by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable long id){
        Utilisateur utilisateur = utilisateurService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id:" + id));
        return ResponseEntity.ok(utilisateur);

    }





    // build update Utilisateur REST API
    @PutMapping("{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable long id,@RequestBody Utilisateur utilisateurDetails) {
        Utilisateur updateUtilisateur = utilisateurService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        updateUtilisateur.setFirstName(utilisateurDetails.getFirstName());
        updateUtilisateur.setLastName(utilisateurDetails.getLastName());
        updateUtilisateur.setEmail(utilisateurDetails.getEmail());

        utilisateurService.save(updateUtilisateur);

        return ResponseEntity.ok(updateUtilisateur);
    }



    // build delete utilisateur REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUtilisateur(@PathVariable long id){

        Utilisateur utilisateur = utilisateurService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id: " + id));

        utilisateurService.delete(utilisateur);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }







}
