package boursorama.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;


@Stateless
@LocalBean
public class Test {

    @Resource(mappedName="jms/boursoramaTopicFactory")
    TopicConnectionFactory topicConnectionFactory;

    @Resource(mappedName="jms/boursoramaTopicDestination")
    Topic topic;

    private TopicConnection _topicConnection;
    private TopicSession _topicSession;
    private TopicPublisher _topicPublisher;

    @PostConstruct
    public void postConstruct(){

        try {
            _topicConnection = topicConnectionFactory.createTopicConnection();
            _topicSession = _topicConnection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
            _topicPublisher = _topicSession.createPublisher(topic);     
        } catch (JMSException e) {          
            e.printStackTrace();
        }       
    }

    @PreDestroy
    public void preDestroy(){
        try {
            _topicConnection.close();   
            _topicConnection = null;        
        } catch (JMSException e) {          
            e.printStackTrace();
        }    
    }

    public Test() {
        // TODO Auto-generated constructor stub
    }



    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void test(){
        try {
            Message m = _topicSession.createObjectMessage();                
            _topicPublisher.send(m);
        } catch (JMSException e) {          
            e.printStackTrace();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void test2(TopicPublisher to, Message m){
        try {
            to.send(m);
        } catch (JMSException e) {          
            e.printStackTrace();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void test3(Message m){
        try {
            _topicPublisher.send(m);
        } catch (JMSException e) {          
            e.printStackTrace();
        }
    }



}