/**
 * @author Maiju
 * @version 1.00 2016/6/6
 */

package havainnot;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Havainto implements Serializable{
	private String kissa_nimi;
	private String henkilo_nimi;
	private String paikka;
	private String paivamaara;
	private int kissa_id;
	
	/**
	 * Havainto -luokan alustaja
	 * @param kissa_nimi
	 * @param henkilo_nimi
	 * @param paikka
	 * @param paivamaara
	 * @param kissa_id
	 */
	public Havainto(String kissa_nimi, String henkilo_nimi, String paikka, String paivamaara, int kissa_id) {
		super();
		this.kissa_nimi = kissa_nimi;
		this.henkilo_nimi = henkilo_nimi;
		this.paikka = paikka;
		this.paivamaara = paivamaara;
		this.kissa_id = kissa_id;
	}
	/**
	 *Palauttaa kissan nimen 
	 * @return 
	 */
	public String getKissa_nimi() {
		return kissa_nimi;
	}
	/**
	 * Asettaa kissan nimen
	 * @param kissa_nimi 
	 */
	public void setKissa_nimi(String kissa_nimi) {
		this.kissa_nimi = kissa_nimi;
	}
	/**
	 * Palauttaa havaitsijan nimen
	 * @return
	 */
	public String getHenkilo_nimi() {
		return henkilo_nimi;
	}
	/**
	 * Asettaa havaitsijan nimen
	 * @param henkilo_nimi
	 */
	public void setHenkilo_nimi(String henkilo_nimi) {
		this.henkilo_nimi = henkilo_nimi;
	}
	/**
	 * Palauttaa havaintopaikan
	 * @return
	 */
	public String getPaikka() {
		return paikka;
	}
	/**
	 * Asettaa havaintopaikan
	 * @param paikka
	 */
	public void setPaikka(String paikka) {
		this.paikka = paikka;
	}
	/**
	 * Palauttaa havaintopäivämäärän
	 * @return
	 */
	public String getPaivamaara() {
		return paivamaara;
	}
	/**
	 * Asettaa havaintopäivämäärän
	 * @param paivamaara
	 */
	public void setPaivamaara(String paivamaara) {
		this.paivamaara = paivamaara;
	}
	/**
	 * Palauttaa kissan id-numeron
	 * @return
	 */
	public int getKissa_id() {
		return kissa_id;
	}
	/**
	 * Asettaa kissan id-numeron
	 * @param kissa_id
	 */
	public void setKissa_id(int kissa_id) {
		this.kissa_id = kissa_id;
	}
	/**
	 * Tulostaa olion tiedot
	 */
	@Override
	public String toString() {
		return "Havainto [Kissan nimi =" + kissa_nimi + ", Havaitsijan nimi =" + henkilo_nimi + ", Havaintopaikka=" + paikka
				+ ", Päivämäärä =" + paivamaara + ", Kissan id-numero=" + kissa_id + "]";
	}
	
	



}