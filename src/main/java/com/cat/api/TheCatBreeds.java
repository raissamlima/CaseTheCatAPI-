package com.cat.api;

//https://api.thecatapi.com/v1/images/search?breed_id=beng

public class TheCatBreeds {

	private String id;
	private String name;
	private String temperament;
	private String life_span;
	private String alt_names;
	private String wikipedia_url;
	private String origin;
	private String weight_imperial;
	private Integer experimental;
	private Integer hairless;
	private Integer natural;
	private Integer rare;
	private Integer rex;
	private Integer suppress_tail;
	private Integer short_legs;
	private Integer hypoallergenic;
	private Integer adaptability;
	private Integer affection_level;
	private String country_code;
	private Integer child_friendly;
	private Integer dog_friendly;
	private Integer energy_level;
	private Integer grooming;
	private Integer health_issues;
	private Integer intelligence;
	private Integer shedding_level;
	private Integer social_needs;
	private Integer stranger_friendly;
	private Integer vocalisation;

	public TheCatBreeds() {
	}

	public TheCatBreeds(String id, String name, String temperament, String life_span, String alt_names,
			String wikipedia_url, String origin, String weight_imperial, Integer experimental, Integer hairless,
			Integer natural, Integer rare, Integer rex, Integer suppress_tail, Integer short_legs,
			Integer hypoallergenic, Integer adaptability, Integer affection_level, String country_code,
			Integer child_friendly, Integer dog_friendly, Integer energy_level, Integer grooming, Integer health_issues,
			Integer intelligence, Integer shedding_level, Integer social_needs, Integer stranger_friendly, Integer vocalisation) {
		
		this.id = id;
		this.name = name;
		this.temperament = temperament;
		this.life_span = life_span;
		this.alt_names = alt_names;
		this.natural = natural;
		this.rare = rare;
		this.rex = rex;
		this.suppress_tail = suppress_tail;
		this.short_legs = short_legs;
		this.hypoallergenic = hypoallergenic;
		this.adaptability = adaptability;
		this.affection_level = affection_level;
		this.country_code = country_code;
		this.child_friendly = child_friendly;
		this.dog_friendly = dog_friendly;
		this.energy_level = energy_level;
		this.grooming = grooming;
		this.health_issues = health_issues;
		this.intelligence = intelligence;
		this.shedding_level = shedding_level;
		this.social_needs = social_needs;
		this.stranger_friendly = stranger_friendly;
		this.vocalisation = vocalisation;
}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTemperament() {
		return temperament;
	}

	public String getLife_span() {
		return life_span;
	}

	public String getAlt_names() {
		return alt_names;
	}

	public String getWikipedia_url() {
		return wikipedia_url;
	}

	public String getOrigin() {
		return origin;
	}

	public String getWeight_imperial() {
		return weight_imperial;
	}

	public Integer getExperimental() {
		return experimental;
	}

	public Integer getHairless() {
		return hairless;
	}

	public Integer getNatural() {
		return natural;
	}

	public Integer getRare() {
		return rare;
	}

	public Integer getRex() {
		return rex;
	}

	public Integer getSuppress_tail() {
		return suppress_tail;
	}

	public Integer getShort_legs() {
		return short_legs;
	}

	public Integer getHypoallergenic() {
		return hypoallergenic;
	}

	public Integer getAdaptability() {
		return adaptability;
	}

	public Integer getAffection_level() {
		return affection_level;
	}

	public String getCountry_code() {
		return country_code;
	}

	public Integer getChild_friendly() {
		return child_friendly;
	}

	public Integer getDog_friendly() {
		return dog_friendly;
	}

	public Integer getEnergy_level() {
		return energy_level;
	}

	public Integer getGrooming() {
		return grooming;
	}

	public Integer getHealth_issues() {
		return health_issues;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public Integer getShedding_level() {
		return shedding_level;
	}

	public Integer getSocial_needs() {
		return social_needs;
	}

	public Integer getStranger_friendly() {
		return stranger_friendly;
	}

	public Integer getVocalisation() {
		return vocalisation;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	public void setLife_span(String life_span) {
		this.life_span = life_span;
	}

	public void setAlt_names(String alt_names) {
		this.alt_names = alt_names;
	}

	public void setWikipedia_url(String wikipedia_url) {
		this.wikipedia_url = wikipedia_url;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setWeight_imperial(String weight_imperial) {
		this.weight_imperial = weight_imperial;
	}

	public void setExperimental(Integer experimental) {
		this.experimental = experimental;
	}

	public void setHairless(Integer hairless) {
		this.hairless = hairless;
	}

	public void setNatural(Integer natural) {
		this.natural = natural;
	}

	public void setRare(Integer rare) {
		this.rare = rare;
	}

	public void setRex(Integer rex) {
		this.rex = rex;
	}

	public void setSuppress_tail(Integer suppress_tail) {
		this.suppress_tail = suppress_tail;
	}

	public void setShort_legs(Integer short_legs) {
		this.short_legs = short_legs;
	}

	public void setHypoallergenic(Integer hypoallergenic) {
		this.hypoallergenic = hypoallergenic;
	}

	public void setAdaptability(Integer adaptability) {
		this.adaptability = adaptability;
	}

	public void setAffection_level(Integer affection_level) {
		this.affection_level = affection_level;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public void setChild_friendly(Integer child_friendly) {
		this.child_friendly = child_friendly;
	}

	public void setDog_friendly(Integer dog_friendly) {
		this.dog_friendly = dog_friendly;
	}

	public void setEnergy_level(Integer energy_level) {
		this.energy_level = energy_level;
	}

	public void setGrooming(Integer grooming) {
		this.grooming = grooming;
	}

	public void setHealth_issues(Integer health_issues) {
		this.health_issues = health_issues;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public void setShedding_level(Integer shedding_level) {
		this.shedding_level = shedding_level;
	}

	public void setSocial_needs(Integer social_needs) {
		this.social_needs = social_needs;
	}

	public void setStranger_friendly(Integer stranger_friendly) {
		this.stranger_friendly = stranger_friendly;
	}

	public void setVocalisation(Integer vocalisation) {
		this.vocalisation = vocalisation;
	}
}
