/* Copyright 2009 University of Cambridge
 * Licensed under the Educational Community License (ECL), Version 2.0. You may not use this file except in 
 * compliance with this License.
 *
 * You may obtain a copy of the ECL 2.0 License at https://source.collectionspace.org/collection-space/LICENSE.txt
 */
package org.collectionspace.chain.storage;

import org.json.JSONObject;

/** The core SVCAPP interface.
 * 
 */
public interface Storage {

	/**
	 * Generates JSON string from a file storing the information
	 * 
	 * @param filePath - path to the file
	 * @return  String of valid JSON format, or an empty string if an error was encountered.
	 */
	public abstract JSONObject retrieveJSON(String filePath)
		throws ExistException, UnimplementedException, UnderlyingStorageException;

	/**
	 * Parses and stores the given JSONObject in a file in the given path, if it already exists.
	 * 
	 * @param filePath - path to file for storage
	 * @param jsonObject - the JSONObject to be parsed and stored
	 */
	public abstract void updateJSON(String filePath, JSONObject jsonObject)
		throws ExistException, UnimplementedException, UnderlyingStorageException;

	/**
	 * Parses and stores the given JSONObject in a file in the given path, if it does not exist.
	 * 
	 * @param filePath - path to file for storage
	 * @param jsonObject - the JSONObject to be parsed and stored
	 */
	public abstract void createJSON(String filePath, JSONObject jsonObject)
		throws ExistException, UnimplementedException, UnderlyingStorageException;

	public abstract String autocreateJSON(String filePath, JSONObject jsonObject)
		throws ExistException, UnimplementedException, UnderlyingStorageException;
	
	public String[] getPaths(String rootPath)
		throws ExistException, UnimplementedException, UnderlyingStorageException;
	
	public void deleteJSON(String filePath)
		throws ExistException, UnimplementedException, UnderlyingStorageException;
}