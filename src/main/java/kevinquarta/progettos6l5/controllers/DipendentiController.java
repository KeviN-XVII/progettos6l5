package kevinquarta.progettos6l5.controllers;


import kevinquarta.progettos6l5.entities.Dipendente;
import kevinquarta.progettos6l5.excpetions.ValidationException;
import kevinquarta.progettos6l5.payloads.DipendenteDTO;
import kevinquarta.progettos6l5.services.DipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    public DipendentiService  dipendentiService;

    @Autowired
    public DipendentiController(DipendentiService dipendentiService) {
        this.dipendentiService = dipendentiService;
    }

//    POST /dipendenti crea nuovo dipendente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente saveDipendente(@RequestBody @Validated DipendenteDTO payload, BindingResult validationResult){
        if(validationResult.hasErrors()){
            List<String> errorsList = validationResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();
            throw new ValidationException(errorsList);
        } else {
            return this.dipendentiService.saveDipendente(payload);
        }
    }

//  GET /dipendenti ritorna lista di dipendenti
     @GetMapping
     public Page<Dipendente> findAll(@RequestParam(defaultValue = "0")int page,
                          @RequestParam(defaultValue = "10")int size,
                          @RequestParam(defaultValue = "name")String orderBy,
                          @RequestParam(defaultValue = "asc")String sortCriteria) {
     return dipendentiService.findAll(page, size, orderBy, sortCriteria);
     }

//   GET /dipendenti/123 ritorna un singolo dipendente
     @GetMapping("/{userId}")
     public Dipendente getUserById(@PathVariable long userId) {
        return dipendentiService.findById(userId);
     }












}
