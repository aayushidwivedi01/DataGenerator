/*
 * Copyright 2014 DataGenerator Contributors
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
package org.finra.datagenerator.writer;

import org.apache.log4j.Logger;
import org.finra.datagenerator.consumer.DataPipe;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Orders result variables based on a template and writes them seperated by pipe characters to a given OutputStream.
 *
 * Created by robbinbr on 5/28/2014.
 */
public class DefaultWriter implements DataWriter {

    /**
     * Logger
     */
    protected static final Logger log = Logger.getLogger(DefaultWriter.class);
    private final OutputStream os;
    private String[] outTemplate;

    /**
     * Constructor
     *
     * @param os the output stream to use in writing
     * @param outTemplate the output template to format writing
     */
    public DefaultWriter(final OutputStream os, final String[] outTemplate) {
        this.os = os;
        this.outTemplate = outTemplate;
    }

    @Override
    public void writeOutput(DataPipe cr) {
        try {
            //System.out.println("Default Printer");
            os.write(cr.getPipeDelimited(outTemplate).getBytes());
            os.write("\n".getBytes());
        } catch (IOException e) {
            log.error("IOException in DefaultConsumer", e);
        }
    }
}
