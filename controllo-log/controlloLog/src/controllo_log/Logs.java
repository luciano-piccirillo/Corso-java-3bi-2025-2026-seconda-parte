package controllo_log;

import java.io.BufferedReader;
import java.io.FileReader;

public class Logs {

    // dati[] è l'array in cui teniamo tutti i Log
    private Log dati[];
    private String fileName;
    // headers[] è l'array in cui mettiamo l'intestazione(la prima riga del file)
    private String headers[];
    private String separatore;
    private boolean intestazione;
    private String rawData[];
    private int count;
    private double incremento;

    public Logs(int nrLogs, double incrememnto){
        // l'incremento è il metodo che utilizziamo per aumentare la dimensione dell'array, in questo caso del 25%
        this.incremento = 0.25;
        this.count = nrLogs;
        this.dati = new Log[nrLogs];
    }

      public Logs(int nrLogs){
        this(nrLogs, 0.25);
    }

    public Logs(){
        // Se non viene specificato il numero di log creo un array con 1000 elementi
        this(1000);
    }

    public Logs(String fileName){

    }

    private void aumentaDimensione(){
        this.aumentaDimensione(0);
    }

    private void aumentaDimensione(int nrNuoviElementi){
        // La nuova dimensione è la dimensione attuale più l'incremento
        int nuovaDimensione = (int) (this.dati.length * this.incremento) + this.dati.length + nrNuoviElementi;
        // Creo un nuovo array con la nuova dimensione
        Log tmp[] = new Log[nuovaDimensione];
        for (int i = 0; i < this.dati.length; i++) {
            tmp[i] = this.dati[i];
        }
        this.dati = tmp;
    }

    private int contaRighe(String fileName, boolean intestazione,) throws Exception {
        return -1;
    } 

    public void caricaFile(String fileName, boolean intestazione, String separatore){
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String riga;
            int i = 0;
            if (intestazione) {
                riga = br.readLine();
                this.headers = riga.split(separatore);
            }
            while ((riga = br.readLine()) != null) {
                this.dati[i] = new Log(riga, separatore);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}