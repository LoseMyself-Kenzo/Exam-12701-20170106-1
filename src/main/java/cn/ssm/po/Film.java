package cn.ssm.po;

import java.math.BigDecimal;
import java.util.Date;

public class Film {
	private int film_id;

	private String title;

	private Date releaseYear;

	private int language_id;

	private Byte originalLanguageId;

	private Byte rentalDuration;

	private BigDecimal rentalRate;

	private Short length;

	private BigDecimal replacementCost;

	private String rating;

	private String special_features;

	private Date lastUpdate;

	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public Byte getOriginalLanguageId() {
		return originalLanguageId;
	}

	public void setOriginalLanguageId(Byte originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public Byte getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Short getLength() {
		return length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

}