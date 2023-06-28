package com.lowtechsoft.transfer.json;

public class JSONReaderTest {

    public static void main(String[] args){
        String json = "{\n" +
                " \"fiumqov\": [\n" +
                "  [\n" +
                "   421334982\n" +
                "  ]\n" +
                " ],\n" +
                " \"msnrpcaxpd\": true,\n" +
                " \"uwflzunhfvn\": -170496837\n" +
                "}";

        json = "{\n" +
                " \"ymryqaoiuwk\": {\n" +
                "  \"ugcveyh\": [\n" +
                "   true,\n" +
                "   -2092882938,\n" +
                "   -339840330\n" +
                "  ],\n" +
                "  \"ghpowejdcj\": \"_c673XS5J_Ze9\",\n" +
                "  \"fsmkywcggcd\": \"S\"\n" +
                " },\n" +
                " \"ogugxnc\": 1965931853,\n" +
                " \"kyjxrvzupz\": [\n" +
                "  \"9IMnoGChKc8\",\n" +
                "  [\n" +
                "   \"08i8sKRL7gpG\",\n" +
                "   false\n" +
                "  ]\n" +
                " ]\n" +
                "}";

        json = "[\n" +
                " {\n" +
                "  \"xsrqqvzl\": {\n" +
                "   \"mrosb\": {\n" +
                "    \"poeycuurfk\": false,\n" +
                "    \"lhfwah\": [\n" +
                "     -364190389.7001521,\n" +
                "     true,\n" +
                "     -214001013\n" +
                "    ],\n" +
                "    \"igiogqbxeqdz\": -339480026.359874,\n" +
                "    \"voleiclzzx\": false,\n" +
                "    \"fyltoupeg\": [\n" +
                "     true,\n" +
                "     \"LRFylPyfjMgafBLGPj\"\n" +
                "    ]\n" +
                "   },\n" +
                "   \"vzqkrhcu\": -738676886.6928409,\n" +
                "   \"ttzjcv\": {\n" +
                "    \"xfkvhfafvkt\": \"1\",\n" +
                "    \"zjtxqeo\": -124829149.837775,\n" +
                "    \"hzqvnqw\": -1040334178,\n" +
                "    \"wpnra\": true\n" +
                "   },\n" +
                "   \"waflohzgs\": {\n" +
                "    \"qjcjstectve\": true,\n" +
                "    \"yuqxwdjfdc\": \"DD3x-dxJuvMVfT1oCJ\",\n" +
                "    \"llczmrifjb\": 1906486592,\n" +
                "    \"ekfnxzejya\": [\n" +
                "     true,\n" +
                "     525524786.02254975\n" +
                "    ]\n" +
                "   },\n" +
                "   \"nyjxk\": {\n" +
                "    \"idwwhryo\": -753587078.7160835,\n" +
                "    \"wktytropiykt\": \"6WpusUGH\",\n" +
                "    \"dbysdflwzaoo\": 1738118394.5714111\n" +
                "   }\n" +
                "  },\n" +
                "  \"pcaaqtdf\": false,\n" +
                "  \"xrcdwgcsydlm\": true\n" +
                " }\n" +
                "]";

        JSONReader reader = new JSONReader(json);
        try {
            Object ret = reader.parse();
            System.out.println(ret);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
