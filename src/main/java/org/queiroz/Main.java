package org.queiroz;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Verifica se os argumentos necessários foram fornecidos
        if (args.length < 4) {
            System.out.println("Uso: java AmigoOcultoApp <phone> <caminho_arquivo_csv> <url_api_sms> <auth_token>");
            return;
        }

        String phone = args[0];
        String caminhoArquivoCSV = args[1];
        String urlApiSms = args[2];
        String authToken = args[3];

        try {
            Map<String, String> contatos = CSVReader.lerCSV(caminhoArquivoCSV);
            ArrayList<String> participantes = new ArrayList<>(contatos.keySet());
            Map<String, String> sorteio = AmigoOculto.sortearAmigoOculto(participantes);

            for (Map.Entry<String, String> entrada : sorteio.entrySet()) {
                String remetente = entrada.getKey();
                String destinatario = entrada.getValue();
                String mensagem = "Olá " + remetente + ", você tirou " + destinatario + " no amigo oculto!";

                // Envia a mensagem via SMS
                SmsSender.enviarSms(phone, contatos.get(remetente), mensagem, urlApiSms, authToken);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
