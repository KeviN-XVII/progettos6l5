package kevinquarta.progettos6l5.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="dipendenti")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private String nome;
    private String cognome;
    private String email;
    private String avatar;

    public Dipendente(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }
}
