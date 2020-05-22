const payload = {
                data: {
                    title: "title",
                    body: `body`,
                    icon: "default",
                    sound: "default"
                }
            };

            const options = {
                priority: "high",
                timeToLive: 60 * 10
            };

            return admin.messaging().sendToTopic("notifyAll", payload, options)
                .then((response) => {
                    console.log("Successfully sent message:", response);
                    return response;
                })
                .catch((error) => {
                    console.log("Error sending message:", error);
                    return error;
});