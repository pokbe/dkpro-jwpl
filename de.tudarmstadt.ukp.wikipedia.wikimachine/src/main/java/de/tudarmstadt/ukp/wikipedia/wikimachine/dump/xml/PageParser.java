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
package de.tudarmstadt.ukp.wikipedia.wikimachine.dump.xml;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

import de.tudarmstadt.ukp.wikipedia.wikimachine.util.UTFDataInputStream;

public class PageParser {
	/**
	 * Needed fields from the table page.<br>
	 * These fields are updated each time the method next() returns true.
	 */
	protected int pageId;
	protected int pageNamespace;
	protected String pageTitle;
	protected boolean pageIsRedirect;

	protected UTFDataInputStream stream;

	/**
	 * Create a parser from an input stream
	 * 
	 * @param inputStream
	 * @author ivan.galkin
	 */
	public void setInputStream(InputStream inputStream) {
		stream = new UTFDataInputStream(inputStream);
	}

	/**
	 * @return Returns the page_id.
	 */
	public int getPageId() {
		return pageId;
	}

	/**
	 * @return Returns the page_is_redirect.
	 */
	public boolean getPageIsRedirect() {
		return pageIsRedirect;
	}

	/**
	 * @return Returns the page_namespace.
	 */
	public int getPageNamespace() {
		return pageNamespace;
	}

	/**
	 * @return Returns the page_title.
	 */
	public String getPageTitle() {
		return pageTitle;
	}

	/**
	 * Returns true if the table has more rows.
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean next() throws IOException {
		boolean hasNext = true;
		try {
			pageId = stream.readInt();
			pageNamespace = stream.readInt();
			pageTitle = stream.readUTFAsArray();
			pageIsRedirect = stream.readBoolean();
		} catch (EOFException e) {
			hasNext = false;
		}
		return hasNext;
	}

	public void close() throws IOException {
		stream.close();
	}
}
