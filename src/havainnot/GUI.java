/**
 * @author Maiju
 * @version 1.00 6/6/2016
 */
package havainnot;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
/**
 * Graafinen k‰yttˆliittym‰ kissahavainnot -projektille
 * @author Maiju
 *
 */
public class GUI extends Application implements Serializable {
	private TextField tfKissanimi = new TextField();
	private TextField tfHavaitsija = new TextField();
	private TextField tfAika = new TextField();
	private TextField tfPaikka = new TextField();
	private TextField tfKissa_id = new TextField();

	private Button btTallenna = new Button("Tallenna");
	private Button btEtsi = new Button("Etsi");
	private Button btLopeta = new Button("Lopeta");

	ArrayList<Havainto> havainnot = null;
/**
 * K‰yttˆliittym‰n p‰‰ikkuna
 * @param alkuIkkuna
 */
	@Override
	public void start(Stage alkuIkkuna) {
		GridPane paneeli = new GridPane();

		paneeli.setHgap(5);
		paneeli.setVgap(5);

		paneeli.add(new Label("Kissan nimi: "), 0, 0);
		paneeli.add(tfKissanimi, 1, 0);
		paneeli.add(new Label("Kissan id-numero: "), 0, 1);
		paneeli.add(tfKissa_id, 1, 1);
		paneeli.add(new Label("P‰iv‰m‰‰r‰: "), 0, 2);
		paneeli.add(tfAika, 1, 2);
		paneeli.add(new Label("Paikka: "), 0, 3);
		paneeli.add(tfPaikka, 1, 3);
		paneeli.add(new Label("Havaitsija: "), 0, 4);
		paneeli.add(tfHavaitsija, 1, 4);

		paneeli.add(btTallenna, 1, 5);
		paneeli.add(btEtsi, 1, 6);
		paneeli.add(btLopeta, 2, 6);

		// m‰‰ritell‰‰n asettelua
		paneeli.setAlignment(Pos.CENTER);
		tfKissanimi.setAlignment(Pos.BOTTOM_RIGHT);
		tfHavaitsija.setAlignment(Pos.BOTTOM_RIGHT);
		tfAika.setAlignment(Pos.BOTTOM_RIGHT);
		tfPaikka.setAlignment(Pos.BOTTOM_RIGHT);

		// k‰sitell‰‰n tapahtumat
		btTallenna.setOnAction(e -> Tallenna(havainnot));
		btEtsi.setOnAction(e -> Etsi(havainnot));
		btLopeta.setOnAction(e -> Lopeta());

		Scene kehys = new Scene(paneeli, 400, 250);
		alkuIkkuna.setTitle("Kissahavainnot");
		alkuIkkuna.setScene(kehys);
		alkuIkkuna.show();
		havainnot = Luetiedosto();

	}
/**
 * Metodi tallentaa tekstikenttien pohjalta luodun olion tiedostoon
 * Metodi luo olion tekstikenttien pohjalta, lis‰‰ sen havainnot -listaan,
 * ja kirjoittaa listan tiedostoon.
 * @param havainnot Lista joka sis‰lt‰‰ tiedostossa olleet oliot
 * @return palauttaa muokatun listan
 */
	private ArrayList<Havainto> Tallenna(ArrayList<Havainto> havainnot) {

		String kissanimi = tfKissanimi.getText();
		String havaitsija = tfHavaitsija.getText();
		String aika = tfAika.getText();
		String paikka = tfPaikka.getText();
		int kissa_id = Integer.parseInt(tfKissa_id.getText());
		ObjectOutputStream tiedosto = null;
		Havainto havainto = new Havainto(kissanimi, havaitsija, paikka, aika, kissa_id);
		try {

			havainnot.add(havainto);
			tiedosto = new ObjectOutputStream(new FileOutputStream("havainnot.dat"));
			tiedosto.writeObject(havainnot);
			System.out.println("Tiedot tallennettu.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (tiedosto != null)
					tiedosto.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return havainnot;

	}
/**
 * Metodi etsii yhden teksikent‰n tiedon avulla olioita.
 * Metodi ottaa tutkittavaksi yhden tekstikent‰n, k‰y l‰pi havainnot -listaa,
 * ja n‰ytt‰‰ kaikki oliot joissa on t‰m‰ sama tieto. 
 * @param havainnot Tiedostosta luettu oliolista.
 */
	private void Etsi(ArrayList<Havainto> havainnot) {
		int i;
		String kissanimi = tfKissanimi.getText();
		String havaitsija = tfHavaitsija.getText();
		String aika = tfAika.getText();
		String paikka = tfPaikka.getText();

		if (kissanimi != " ") {
			String etsi = kissanimi;
			for (i = 0; i < havainnot.size(); i++) {
				if (havainnot.get(i).getKissa_nimi().equals(etsi)) {
					System.out.println(havainnot.get(i));
				}

			}

		} if (havaitsija != " ") {
			String etsi = havaitsija;
			for (i = 0; i < havainnot.size(); i++) {
				if (havainnot.get(i).getHenkilo_nimi().equals(etsi)) {
					System.out.println(havainnot.get(i));
				}
			}

		} if (aika != "") {
			String etsi = aika;
			for (i = 0; i < havainnot.size(); i++) {
				if (havainnot.get(i).getPaivamaara().equals(etsi)) {
					System.out.println(havainnot.get(i));
				}
			}
		} if (paikka != "") {
			String etsi = paikka;
			for (i = 0; i < havainnot.size(); i++) {
				if (havainnot.get(i).getPaikka().equals(etsi)) {
					System.out.println(havainnot.get(i));
				}
			}

		} if (tfKissa_id.getText() != "") {
			try{
			int etsi = Integer.parseInt(tfKissa_id.getText());
			for (i = 0; i < havainnot.size(); i++) {
				if (havainnot.get(i).getKissa_id()==etsi) {
					System.out.println(havainnot.get(i));
				}
			}
			}catch(NumberFormatException e){
				
			}

		}

		// Havainto havainto = new Havainto(kissanimi, havaitsija, aika, paikka,
		// kissa_id);

	}
/**
 * Metodi lukee havainnot.dat -tiedoston listaksi.
 * Metodi lukee tiedoston ohjelman k‰ynnistyess‰. Listaa k‰ytet‰‰n
 * tallenna- ja etsi -metodeissa.
 * @return Palauttaa luetun listan.
 */
	private ArrayList<Havainto> Luetiedosto() {

		ObjectInputStream lTiedosto = null;
		ArrayList<Havainto> havainnot = new ArrayList<Havainto>();

		try {
			lTiedosto = new ObjectInputStream(new FileInputStream("havainnot.dat"));
			havainnot = (ArrayList<Havainto>) lTiedosto.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		finally {

			try {
				if (lTiedosto != null)
					lTiedosto.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return havainnot;

	}
/**
 * Lopettaa ohjelman suorituksen nappia painettaessa.
 */
	private void Lopeta() {
		System.exit(0);
	}
/**
 * K‰ynnist‰‰ ohjelman
 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}