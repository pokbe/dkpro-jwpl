/*******************************************************************************
 * Copyright 2015
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package de.tudarmstadt.ukp.wikipedia.revisionmachine.api;

import java.util.List;

/**
 * Provides basic user/conttributor information in a single object
 *
 * @author Oliver Ferschke
 *
 */
public class Contributor
{
	private String name;
	private Integer id;
	private List<String> groups;

	public Contributor(String name){
		this.name=name;
	}

	public Contributor(String name, Integer id){
		this.name=name;
		this.id=id;
	}

	public Contributor(String name, Integer id, List<String> groups){
		this.name=name;
		this.id=id;
		this.groups=groups;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String aName)
	{
		name = aName;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer aId)
	{
		id = aId;
	}
	public List<String> getGroups()
	{
		return groups;
	}
	public void setGroups(List<String> groups)
	{
		this.groups = groups;
	}

}
