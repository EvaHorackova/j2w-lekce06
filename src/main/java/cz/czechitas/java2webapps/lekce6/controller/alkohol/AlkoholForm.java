package cz.czechitas.java2webapps.lekce6.controller.alkohol;

import jakarta.validation.constraints.*;

/**
 */
public class AlkoholForm {
  @NotBlank
  private String zbozi;
  @NotNull // pravidlo validace - kontroluje ne/vyplněnost hodnoty (vyhoví prázdný string)
  private Objem objem; // enum
  @NotBlank
  private String jmeno;
  @Min(18) // int, pravidlo validace - min, max
  @Max(150)
  private int vek;
  @Email // pravidlo validace - e-mail (@, nepovolené znaky)
  @NotBlank // pravidlo validace - kontroluje ne/vyplněnost hodnoty (nevyhoví prázdný string)
  private String email;
  @AssertTrue
  private boolean obchodniPodminky; // checkbox s neudělením/udělením souhlasu (bool), pravidlo validace - kontroluje vyplněnost hodnoty true
  private boolean newsletter; // checkbox s neudělením/udělením souhlasu (bool)

  public String getZbozi() {
    return zbozi;
  }

  public void setZbozi(String zbozi) {
    this.zbozi = zbozi;
  }

  public Objem getObjem() {
    return objem;
  }

  public void setObjem(Objem objem) {
    this.objem = objem;
  }

  public String getJmeno() {
    return jmeno;
  }

  public void setJmeno(String jmeno) {
    this.jmeno = jmeno;
  }

  public int getVek() {
    return vek;
  }

  public void setVek(int vek) {
    this.vek = vek;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isObchodniPodminky() {
    return obchodniPodminky;
  }

  public void setObchodniPodminky(boolean obchodniPodminky) {
    this.obchodniPodminky = obchodniPodminky;
  }

  public boolean isNewsletter() {
    return newsletter;
  }

  public void setNewsletter(boolean newsletter) {
    this.newsletter = newsletter;
  }
}
