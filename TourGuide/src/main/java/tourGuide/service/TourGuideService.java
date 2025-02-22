package tourGuide.service;

import tourGuide.beans.AttractionBean;
import tourGuide.beans.LocationBean;
import tourGuide.beans.VisitedLocationBean;
import tourGuide.exceptions.UserNotFoundException;
import tourGuide.model.Dto.NearbyAttractionListByUserDto;
import tourGuide.model.user.User;
import tourGuide.model.user.UserReward;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface TourGuideService {

    /**
     * Get a visitedLocation by user
     *
     * @param user the user whose location is sought
     * @return actual user location if its list of visitedLocation is empty otherwise its last visitedLocation
     * @throws ExecutionException   can be thrown when attempting to retrieve the result of trackUserLocation that aborted by throwing an exception.
     * @throws InterruptedException can be thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity.
     */
    VisitedLocationBean getUserLocation(User user) throws ExecutionException, InterruptedException;

    /**
     * Get a user by userName
     *
     * @param userName of user sought
     * @return the user found
     */
    User getUser(String userName);


    /**
     * Get the closest five tourist attractions to the user sorted in ascending order with user location information (longitude and latitude).
     * Each tourist attraction contains :
     * - a name
     * - a location (longitude and latitude)
     * - a distance in miles between the user's location
     * - the reward points for visiting this attraction
     *
     * @param visitedLocationBean a user location
     * @return the closest five tourist attractions to the user sorted in ascending order with all user and attractions information
     */
    NearbyAttractionListByUserDto nearbyAttractionListByUserDto(VisitedLocationBean visitedLocationBean);

    /**
     * Get a list of every user's most recent location
     *
     * @return a map with for each user key = userId and value = {latitude, longitude}
     */
    Map<String, LocationBean> getAllCurrentLocations();

    /**
     * Check if user exist
     *
     * @param user to check
     * @return  true if user exist
     * @throws UserNotFoundException if user doesn't exist
     */
    Boolean isExistingUser(User user) throws UserNotFoundException;

    /**
     * Get an attraction by attraction name
     *
     * @param attractionName the name whose attraction is sought
     * @return attraction found by name
     */
    AttractionBean getAttraction(String attractionName) throws Exception;
}
