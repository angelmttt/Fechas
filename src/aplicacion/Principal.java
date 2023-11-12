import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Principal {
    public static void main(String[] args) {
        
        LocalDateTime fechaActualLocal = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
        DateTimeFormatter formatoEspana = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaEspana = fechaActualLocal.format(formatoEspana);

       
        LocalDateTime fechaActualCaracas = LocalDateTime.now(ZoneId.of("America/Caracas"));
        DateTimeFormatter formatoCaracas = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaCaracas = fechaActualCaracas.format(formatoCaracas);

        
        int anoActual = LocalDateTime.now().getYear();
        int anosTranscurridos = anoActual - 1492;

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaActualMadrid = fechaActualLocal.format(formatoHora);

       
        String horaActualCaracas = fechaActualCaracas.format(formatoHora);

       
        ZoneOffset zonaMadrid = ZoneId.of("Europe/Madrid").getRules().getOffset(fechaActualLocal);
        ZoneOffset zonaCaracas = ZoneId.of("America/Caracas").getRules().getOffset(fechaActualCaracas);
        int diferenciaHoraria = (zonaMadrid.getTotalSeconds() - zonaCaracas.getTotalSeconds())/3600;

        
        LocalDateTime llegadaLuna = LocalDateTime.of(1969, 7, 21, 3, 56);
        ZonedDateTime llegadaLunaMadrid = llegadaLuna.atZone(ZoneId.of("Europe/Madrid"));
        DateTimeFormatter formatoLlegadaLuna = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String horaLlegadaLunaMadrid = llegadaLunaMadrid.format(formatoLlegadaLuna);

        System.out.println("1. Fecha actual en España: " + fechaEspana);
        System.out.println("2. Fecha actual en Caracas: " + fechaCaracas);
        System.out.println("3. Años transcurridos desde el descubrimiento de América: " + anosTranscurridos);
        System.out.println("4. Hora actual en Madrid: " + horaActualMadrid);
        System.out.println("5. Hora actual en Caracas: " + horaActualCaracas);
        System.out.println("6. Diferencia horaria entre Madrid y Caracas es de " + diferenciaHoraria + " horas");
        System.out.println("7. Hora de la llegada de Neil Armstrong a la luna (hora de Madrid): " + horaLlegadaLunaMadrid);
    }
}