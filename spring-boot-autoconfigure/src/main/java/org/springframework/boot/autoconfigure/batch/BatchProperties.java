/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.batch;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for Spring Batch.
 *
 * @author Stephane Nicoll
 * @author Eddú Meléndez
 * @since 1.2.0
 */
@ConfigurationProperties("spring.batch")
public class BatchProperties {

	private static final String DEFAULT_SCHEMA_LOCATION = "classpath:org/springframework/"
			+ "batch/core/schema-@@platform@@.sql";

	/**
	 * Path to the SQL file to use to initialize the database schema.
	 */
	private String schema = DEFAULT_SCHEMA_LOCATION;

	/**
	 * Table prefix for all the batch meta-data tables.
	 */
	private String tablePrefix;

	private final Initializer initializer = new Initializer();

	private final Job job = new Job();

	public String getSchema() {
		return this.schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public Initializer getInitializer() {
		return this.initializer;
	}

	public Job getJob() {
		return this.job;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}

	public String getTablePrefix() {
		return this.tablePrefix;
	}

	public static class Initializer {

		/**
		 * Create the required batch tables on startup if necessary.
		 */
		private boolean enabled = true;

		public boolean isEnabled() {
			return this.enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

	}

	public static class Job {

		/**
		 * Comma-separated list of job names to execute on startup. By default, all Jobs
		 * found in the context are executed.
		 */
		private String names = "";

		public String getNames() {
			return this.names;
		}

		public void setNames(String names) {
			this.names = names;
		}

	}
}
