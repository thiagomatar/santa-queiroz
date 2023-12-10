package org.queiroz;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {
    public static Map<String, String> lerCSV(String caminhoArquivo) throws Exception {
        Map<String, String> contatos = new HashMap<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(caminhoArquivo));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())
        ) {
            for (CSVRecord csvRecord : csvParser) {
                String nome = csvRecord.get(0);
                String telefone = csvRecord.get(1);
                contatos.put(nome, telefone);
            }
        }
        return contatos;
    }
}
