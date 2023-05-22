<template>

    <v-data-table
        :headers="headers"
        :items="helloStatus"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'HelloStatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "helloId", value: "helloId" },
                { text: "worldId", value: "worldId" },
                { text: "hello", value: "hello" },
                { text: "world", value: "world" },
                { text: "count", value: "count" },
            ],
            helloStatus : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/helloStatuses'))

            temp.data._embedded.helloStatuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.helloStatus = temp.data._embedded.helloStatuses;
        },
        methods: {
        }
    }
</script>

