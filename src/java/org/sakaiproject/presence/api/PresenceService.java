/**********************************************************************************
 * $URL$
 * $Id$
 ***********************************************************************************
 *
 * Copyright (c) 2003, 2004, 2005, 2006 The Sakai Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 * 
 *      http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 *
 **********************************************************************************/

package org.sakaiproject.presence.api;

import java.util.List;

/**
 * <p>
 * A PresenceService keeps track of a session's presence at various locations in the system.
 * </p>
 * <p>
 * Location is a combination of site id, (optional) page id and (optional) tool id
 * </p>
 */
public interface PresenceService
{
	/** This string starts the references to resources in this service. */
	static final String REFERENCE_ROOT = "/presence";

	/** Name for the event of establishing presence at a location. */
	static final String EVENT_PRESENCE = "pres.begin";

	/** Name for the event of ending presence at a location. */
	static final String EVENT_ABSENCE = "pres.end";

	/**
	 * Form a presence reference from a location id
	 * 
	 * @param id
	 *        the location id.
	 * @return A presence reference based on a location id.
	 */
	String presenceReference(String id);

	/**
	 * Construct a location id from site, page, and tool.
	 * 
	 * @param site
	 *        The site id.
	 * @param page
	 *        The page id (optional).
	 * @param tool
	 *        The tool id (optional).
	 * @return a Location Id.
	 */
	String locationId(String site, String page, String tool);

	/**
	 * Form a description for the location.
	 * 
	 * @param location
	 *        The presence location.
	 * @return A description for the location.
	 */
	String getLocationDescription(String location);

	/**
	 * Establish or refresh the presence of the current session in a location.
	 * 
	 * @param session
	 *        The session object.
	 * @param locationId
	 *        A presence location id.
	 */
	void setPresence(String locationId);

	/**
	 * Remove the presence of the current session from a location.
	 * 
	 * @param session
	 *        The session object.
	 * @param locationId
	 *        A presence location id.
	 */
	void removePresence(String locationId);

	/**
	 * Access a List of sessions (UsageSession) now present in a location.
	 * 
	 * @param locationId
	 *        A presence location id.
	 * @return The a List of sessions (UsageSession) now present in the location (may be empty).
	 */
	List getPresence(String locationId);

	/**
	 * Access a List of users (User) now present in a location.
	 * 
	 * @param locationId
	 *        A presence location id.
	 * @return The a List of users (User) now present in the location (may be empty).
	 */
	List getPresentUsers(String locationId);

	/**
	 * Access a List of users (User) now present in a location.
	 * 
	 * @param locationId
	 *        A presence location id.
	 * @param siteId
	 * 		  A siteId (added when integrating PrivacyManager)
	 * 
	 * @return The a List of users (User) now present in the location (may be empty).
	 */
	List getPresentUsers(String locationId, String siteId);

	/**
	 * Access a List of all location ids (String).
	 * 
	 * @return The List of all location ids (Strings) (may be empty).
	 */
	List getLocations();

	/**
	 * Access the time (in seconds) after which a presence will timeout.
	 * 
	 * @return The time (seconds) after which a presence will timeout.
	 */
	int getTimeout();
}
