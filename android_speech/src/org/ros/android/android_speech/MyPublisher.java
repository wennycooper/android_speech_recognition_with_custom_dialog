package org.ros.android.android_speech;

import org.ros.concurrent.CancellableLoop;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Publisher;

import geometry_msgs.PoseStamped;

/**
 * Created by kkuei on 2015/11/11.
 */
public class MyPublisher extends AbstractNodeMain {

    private String topic_name = "MyPublisher/messages";
    private Publisher<std_msgs.String> publisher;

    public MyPublisher() {
        topic_name = "MyPublisher/messages";
    }

    public MyPublisher(String topic)
    {
        topic_name = topic;
    }
    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("MyPublisher/publisher");
    }

    @Override
    public void onStart(final ConnectedNode connectedNode) {

        publisher = connectedNode.newPublisher(topic_name, std_msgs.String._TYPE); ///*std_msgs.String._TYPE*/


    }

    public void publishMessage(String s)    {
        std_msgs.String str = publisher.newMessage();
        str.setData(s);
        publisher.publish(str);
    }

}
