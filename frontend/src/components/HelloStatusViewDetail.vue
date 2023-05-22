<template>

    <v-card outlined>
        <v-card-title>
            HelloStatus # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="HelloId" v-model="item.helloId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="WorldId" v-model="item.worldId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Hello" v-model="item.hello" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="World" v-model="item.world" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Count" v-model="item.count" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'HelloStatusViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/helloStatuses/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

