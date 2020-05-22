/**
 * 
 * This file is part of Jms.publisher sample.
 * 
 *  Jms.publisher is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  Jms.publisher is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with Jms.publisher.  If not, see <http://www.gnu.org/licenses/>.
 *  
 * 
 * AccessManager.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package sonic;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicConnectionFactory;

import config.ConnectionInfo;

public class AccessManager 
{
    private TopicConnection connection = null;
    private TopicSession session = null;
    private TopicPublisher topicPublisher = null;    
    private TopicConnectionFactory connectionFactory = null;
    private ConnectionInfo info = null;

    public AccessManager(ConnectionInfo connectionInfo) throws JMSException
    {
        info = connectionInfo;
    }

    public final void connect() throws JMSException
    {
        connectionFactory = new progress.message.jclient.TopicConnectionFactory(info.getSonicAddress());
        connection = connectionFactory.createTopicConnection(info.getUserName(), info.getPassword());
        connection.start();
        session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        topicPublisher = session.createPublisher(info.getTopic());
        assert (isConnected());
    }

    public void send(String text) throws JMSException  
    {
        TextMessage message = session.createTextMessage(text); // send method
        topicPublisher.publish(message);
    }
    /**
     * Disconnect.
     * @throws JMSException 
     */
    public final void disconnect() throws JMSException 
    {
        if (topicPublisher != null) 
        {
            topicPublisher.close();
            session.close();
            connection.close();
        }

        connection = null;
        session = null;
    }

    /**
     * Checks if is connected.
     * 
     * @return true, if is connected
     */
    public final boolean isConnected() {
        if (session != null) {
            return true;
        }
        return false;
    }
}