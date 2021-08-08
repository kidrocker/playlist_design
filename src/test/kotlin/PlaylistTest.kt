import models.Track
import models.User
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import kotlin.test.assertFails

class PlaylistTest {

    lateinit var user: User
    lateinit var playlist: Playlist

    @Before
    fun setUp() {
        user = User(1, "John Does", true)
        playlist = Playlist(user)
    }

    @Test
    fun addTrack() {
        val track1 = Track(1, "Tiktok", 900)

        playlist.addTrack(track1)

        assertEquals(playlist.getNumberOfTracks(), 1)
    }

    @Test
    fun addTracks() {
        val track1 = Track(1, "Africa", 900)
        val track2 = Track(2, "Bubbly", 1200)
        val track3 = Track(3, "Drops of Jupiter", 600)

        playlist.addTracks(listOf(track1, track2, track3))

        assertEquals(playlist.getNumberOfTracks(), 3)
    }

    @Test
    fun playlistCannotAddDuplicates() {
        val track1 = Track(1, "Africa", 900)
        val track2 = Track(2, "Bubbly", 1200)
        val track3 = Track(1, "Africa", 900)

        playlist.addTracks(listOf(track1, track2, track3))
        assert(playlist.getNumberOfTracks() == 2) // the playlist is expected to ignore duplicates
    }

    @Test
    fun deleteTrack() {
        val track1 = Track(1, "Africa", 900)
        val track2 = Track(2, "Bubbly", 1200)
        playlist.addTracks(listOf(track1, track2))

        playlist.deleteTrack(track1)
        assert(playlist.getNumberOfTracks() == 1)
    }

    @Test
    fun deleteTracks() {
        val track1 = Track(1, "Africa", 900)
        val track2 = Track(2, "Bubbly", 1200)
        val track3 = Track(3, "Drops of Jupiter", 600)
        playlist.addTracks(listOf(track1, track2, track3))

        playlist.deleteTracks(listOf(track1, track3))
        assert(playlist.getNumberOfTracks() == 1)
    }

    @Test
    fun getTotalDuration() {
        val track1 = Track(1, "Africa", 900)
        val track2 = Track(2, "Bubbly", 1200)
        val track3 = Track(3, "Drops of Jupiter", 600)
        playlist.addTracks(listOf(track1, track2, track3))

        assert(playlist.getTotalDuration() == 2700L)
    }

    @Test
    fun getNumberOfTracks() {
        val track1 = Track(1, "Africa", 900)
        val track2 = Track(2, "Bubbly", 1200)
        val track3 = Track(3, "Drops of Jupiter", 600)
        playlist.addTracks(listOf(track1, track2, track3))

        assert(playlist.getNumberOfTracks() == 3)
    }

    @Test
    fun getTrack() {
        val track1 = Track(1, "Africa", 900)
        val track2 = Track(2, "Bubbly", 1200)
        val track3 = Track(3, "Drops of Jupiter", 600)
        playlist.addTracks(listOf(track1, track2, track3))

       assertEquals(playlist.getTrack(1), track1)
    }

    @Test
    fun getAllTracks() {
        val track1 = Track(1, "Africa", 900)
        val track2 = Track(2, "Bubbly", 1200)
        val track3 = Track(3, "Drops of Jupiter", 600)
        playlist.addTracks(listOf(track1, track2, track3))

        assertEquals(playlist.getAllTracks(), listOf(track1, track2, track3))
    }

    // user is not pro we should be able to add a maximum of 100 items. 101>max
    @Test
    fun nonProUserLimit(){
        val items =  mutableListOf<Track>()
        for ( x in 1..101){
            items.add(Track(x, "Song_$x", 900L))
        }
        playlist = Playlist(User(1, "John doe", false))

        assertFails( "Maximum number of tracks exceeded") { playlist.addTracks(items) }
    }

    // user is pro we should be able to add a maximum of 200 items.
    @Test
    fun userIsProLimit(){
        val items =  mutableListOf<Track>()
        for ( x in 1..201){
            items.add(Track(x, "Song_$x", 900L))
        }
        playlist = Playlist(User(1, "John doe", true))

        assertFails( "Maximum number of tracks exceeded") { playlist.addTracks(items) }
    }
}