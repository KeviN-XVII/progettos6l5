package kevinquarta.progettos6l5.excpetions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("La risorsa con id " + id + " non è stata trovata!");
    }
}
