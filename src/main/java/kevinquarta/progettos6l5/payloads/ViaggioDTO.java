package kevinquarta.progettos6l5.payloads;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record ViaggioDTO(
         @NotBlank(message="La destinazione è obbligatoria")
         @Size(min=2, max=30)
         String destinazione,
         @NotNull(message = "La data del viaggio è obbligatoria")
         @Future(message = "Il viaggio deve essere in futuro")
         LocalDate dataViaggio
) {
}
