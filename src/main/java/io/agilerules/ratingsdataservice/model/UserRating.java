package io.agilerules.ratingsdataservice.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.agilerules.ratingsdataservice.util.environment.InstanceInformationService;

public class UserRating {

    private String userId;
    private List<Rating> ratings;
  
    private String containerMetaDataServiceInfo;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }


	public String getContainerMetaDataServiceInfo() {
		return containerMetaDataServiceInfo;
	}

	public void setContainerMetaDataServiceInfo(String containerMetaDataServiceInfo) {
		this.containerMetaDataServiceInfo = containerMetaDataServiceInfo;
	}

	public void initData(String userId, InstanceInformationService instanceInformationService) {
        this.setUserId(userId);
        this.setRatings(Arrays.asList(
                new Rating("100", 3),
                new Rating("200", 4)
        ));
        this.setContainerMetaDataServiceInfo(instanceInformationService.retrieveInstanceInfo());
    }
}
