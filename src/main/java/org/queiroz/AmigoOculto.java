package org.queiroz;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmigoOculto {

    // Método para realizar o sorteio do amigo oculto
    public static Map<String, String> sortearAmigoOculto(List<String> participantes) {
        List<String> sorteio = new ArrayList<>(participantes);
        Map<String, String> resultado = new HashMap<>();

        boolean sorteioValido = false;
        while (!sorteioValido) {
            Collections.shuffle(sorteio);
            sorteioValido = true;
            for (int i = 0; i < sorteio.size(); i++) {
                if (sorteio.get(i).equals(participantes.get(i))) {
                    sorteioValido = false;
                    break;
                }
            }
        }

        for (int i = 0; i < sorteio.size(); i++) {
            resultado.put(participantes.get(i), sorteio.get(i));
        }

        return resultado;
    }
}
