/*package abstraction.distributeur.amerique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import abstraction.distributeur.europe.IDistributeur;
import abstraction.fourni.Acteur;
import abstraction.fourni.Monde;

public class MarcheClients implements Acteur{
	public static double satisfactionIni=0.0;
	public static double prixVenteIni;
	public static double augStVal; //3%
	public static double augPaques;// 4% des ventes de chocolat au total
	public static double augHalloween; //10%
	public static double augNoel; // 8% des ventes de chocolat au total
	public static double nbStepAnnees=26;
	public static double commandesAnneeTotales=6000;
	public static double commandesStepFixe=(commandesAnneeTotales-commandesAnneeTotales*(augStVal+augPaques+augHalloween+augNoel))/nbStepAnnees;
	public static double pourcentageFixe=0.40;
	public static double pourcentageFluctuantTotal=0.2;

	private double satisfaction
	
	public void calculDemandes(){
		double augSaisonniere=0;
		int date=Monde.LE_MONDE.getStep()%26;
		if (date==4){
			augSaisonniere=augStVal;
		}
		if (date==13){
			augSaisonniere=augPaques;
		}
		if (date==22){
			augSaisonniere=augHalloween;
		}
		if (date==26){
			augSaisonniere=augNoel;
		}
		
		double commandesTotalesStep=(commandesStepFixe+augSaisonniere*commandesAnneeTotales)*DistributeurUS.coefAleatoire;
		double prixUS=(((DistribClient) Monde.LE_MONDE.getActeur("distributeurUS")).getPrixClient());
		double prixEU=(((DistribClient) Monde.LE_MONDE.getActeur("Distributeur europe")).getPrixClient());
		double p=prixEU/(prixUS+prixEU);
		
		//double satisfactionUS=(((DistribClient) Monde.LE_MONDE.getActeur("distributeurUS")).getVendu())/vendusUS;
		//double satisfactionEU=(((DistribClient) Monde.LE_MONDE.getActeur("distributeurUS")).getVendu())/vendusUS;
		double satisfactionTotale=satisfactionUS/(satisfactionUS+satisfactionEU);
		
		double fluctuantUS= pourcentageFluctuantTotal*(0.5*p+0.3*satisfactionTotale+0.2*DistributeurUS.coefAleatoire);
		
		double demandeUS=commandesTotalesStep*(pourcentageFixe+fluctuantUS);
		double demandeEU=commandesTotalesStep*(1-(pourcentageFixe+fluctuantUS));
	}
	
	
	private HashMap<IDistributeur, Double> satisfactions;//Hashmap met en relation deux objets ici le distributeur et la satisfaction
	//private HashMap<IDistributeur, Double> prixVente; Pas besoin, on le demande quand on a besoin
	private DemandeMonde demande;
	

	public MarcheClients(){
		this.satisfactions=new  HashMap<IDistributeur, Double>();
		this.prixVente=new HashMap<IDistributeur, Double>();
		
		
	}

	public List<IDistributeur> getDistributeur(){
		//	return this.distributeur;
		Set<IDistributeur> keys = this.satisfactions.keySet();
		List<IDistributeur> res = new ArrayList<IDistributeur>();
		for (IDistributeur d : keys) {
			res.add(d);
		}
		return res;
	}
	
	public void addDistributeur(IDistributeur distributeur){
		this.setSatisfaction(distributeur, satisfactionIni);
	//	this.setPrixVente(distributeur, prixVenteIni);
	}
	 
	public void setSatisfaction(IDistributeur distributeur, double satisfaction){
		this.satisfactions.put(distributeur, satisfaction);
	}
	
	/*public void setPrixVente(IDistributeur distributeur, double prixVente){
		this.prixVente.put(distributeur, prixVente);
	}
	public double getSatisfaction(IDistributeur distributeur) {
		return this.satisfactions.get(distributeur);
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		
	}
	
	
}*/